package dev.vrsek.utils.reflect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ClassUtils {
	public static boolean inheritsFromInterface(Class evaluatedClass, String interfaceType) {
		return inheritsFromInterface(evaluatedClass, interfaceType, false);
	}

	public static boolean inheritsFromInterface(Class evaluatedClass, String interfaceType, boolean recutsive) {
		List<Class> interfaces = Arrays.asList(evaluatedClass.getInterfaces());

		return interfaces.stream().anyMatch(x -> x.getTypeName().equals(interfaceType)
				|| (recutsive && inheritsFromInterface(evaluatedClass, x.getTypeName(), recutsive)));
	}

	public static boolean inheritsFromClass(Class evaluatedClass, String classType) {
		Class superClass = evaluatedClass.getSuperclass();

		if (superClass == null) {
			return false;
		}

		return superClass.getTypeName().equals(classType);
	}

	public static Method findMethod(Class type, String name) {
		// TODO: refactorization
		return Arrays.stream(type.getMethods())
				.filter(x -> x.getName().equals(name))
				.findFirst().orElse(null);
	}
}
