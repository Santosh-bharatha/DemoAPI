package com.demo.quartz.scheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Value;

public class SimpleJob implements Job {

	@Value("${source.path}")
	private String sourcePath;

	@Override
	public void execute(JobExecutionContext jobExecutionContext) {

		try {
			File[] filesInDirectory = new File(sourcePath).listFiles();
			for (File f : filesInDirectory) {
				String filePath = f.getAbsolutePath();
				String fileExtenstion = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());
				if ("csv".equals(fileExtenstion)) {
					File sourceLocation = new File(sourcePath);
					fileProcessingService(sourcePath);
					System.out.println();

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public void fileProcessingService(String filesFolder) {
		
		System.out.println("Invoking fileProcessingService");
		
		try (WatchService service = FileSystems.getDefault().newWatchService()) {

			Map<WatchKey, Path> keyMap = new HashMap<>();
			Path path = Paths.get(filesFolder);
			keyMap.put(path.register(service, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY), path);

			WatchKey watchKey;

			do {
				watchKey = service.take();
				Path eventDir = keyMap.get(watchKey);
				for (WatchEvent<?> event : watchKey.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					Path eventPath = (Path) event.context();
					System.out.println(eventDir + " : " + kind + " : " + eventPath);
				}
			} while (watchKey.reset());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("File processed ...!");
	}
}