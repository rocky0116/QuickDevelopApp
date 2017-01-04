package com.sxwz.quick.app.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.os.Environment;
import android.os.StatFs;

import com.sxwz.quick.app.MyApp;

public class SdCardUtil {

	/**
	 * 获取数据存储路径
	 */
	public static String getSavedDir(String dir) {
		String savedDir = null;

		if (SdCardUtil.SDCardIsExist()) {
			savedDir = SdCardUtil.getExternalStoragePath() + dir;
		} else {
			savedDir = getLocalSaveDir(dir);
		}

		return savedDir;
	}

	private static String getLocalSaveDir(String dir) {
		return MyApp.getContext().getFilesDir().getPath() + dir;
	}

	public static String getLocalDir() {
		return MyApp.getContext().getFilesDir().getParent();
	}

	public static String getExternalStoragePath() {
		// 获取SdCard状态
		String state = Environment.getExternalStorageState();

		// 判断SdCard是否存在并且是可用的
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			if (Environment.getExternalStorageDirectory()
					.canWrite()) {
				return Environment.getExternalStorageDirectory()
						.getPath();
			}
		}
		return null;
	}

	private static boolean SDCardIsExist() {
		return getExternalStoragePath() != null ? true : false;
	}

	/**
	 * 获取存储卡的剩余容量，单位为字节
	 */
	@SuppressWarnings("deprecation")
	public static long getSdCardAvailableStore() {
		String filePath = getExternalStoragePath();
		StatFs statFs = new StatFs(filePath);

		long blocSize = statFs.getBlockSize();
		long availaBlock = statFs.getAvailableBlocks();

		return availaBlock * blocSize;
	}

	@SuppressWarnings("deprecation")
	public static long getSystemAvailableStore() {
		String filePath = Environment.getRootDirectory().getPath();
		StatFs statFs = new StatFs(filePath);

		long blockSize = statFs.getBlockSize();
		long availaBlock = statFs.getAvailableBlocks();

		return availaBlock * blockSize;
	}

	/**
	 * 获取外置SdCard路径
	 */
	public static String getExtSdCardPath() {
		try {
			Runtime runtime = Runtime.getRuntime();
			Process proc = runtime.exec("mount");
			InputStream is = proc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			String line;
			String mount = new String();
			BufferedReader br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				if (line.contains("secure"))
					continue;
				if (line.contains("asec"))
					continue;

				if (line.contains("fat")) {
					String columns[] = line.split(" ");
					if (columns != null && columns.length > 1) {
						mount = mount.concat(columns[1]);
					}
				}
			}

			return mount;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return getExternalStoragePath();
	}
}
