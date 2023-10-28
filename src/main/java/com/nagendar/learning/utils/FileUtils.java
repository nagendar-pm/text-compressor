/*
 * @author: pagidimarri.nagendar
 * @createdAt: 27/10/23 9:24 pm
 */

package com.nagendar.learning.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
	public static String toAbsolutePath(String maybeRelative) {
		Path path = Paths.get(maybeRelative);
		Path effectivePath = path;
		if (!path.isAbsolute()) {
			Path base = Paths.get("");
			effectivePath = base.resolve(path).toAbsolutePath();
		}
		return effectivePath.normalize().toString();
	}
}
