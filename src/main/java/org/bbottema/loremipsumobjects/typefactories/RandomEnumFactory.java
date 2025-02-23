package org.bbottema.loremipsumobjects.typefactories;

import org.bbottema.loremipsumobjects.ClassUsageInfo;
import org.bbottema.loremipsumobjects.LoremIpsumConfig;
import org.bbottema.loremipsumobjects.typefactories.util.LoremIpsumGenerator;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class RandomEnumFactory<T extends Enum<?>> extends LoremIpsumObjectFactory<T> {

	private final Class<T> clazz;

	public RandomEnumFactory(final Class<T> clazz) {
		this.clazz = clazz;
	}

	/**
	 * @param knownInstances   Not used.
	 * @param loremIpsumConfig Not used.
	 * @param exceptions       Not used.
	 * @return A random enum from the list acquired by invoking {@link Class#getEnumConstants()} on the requested type.
	 */
	@Override
	public T _createLoremIpsumObject(
			@Nullable final Type[] genericMetaData,
			@Nullable final Map<String, ClassUsageInfo<?>> knownInstances,
			LoremIpsumConfig loremIpsumConfig,
			@Nullable final List<Exception> exceptions) {
		final T[] enums = clazz.getEnumConstants();
		return enums[LoremIpsumGenerator.getInstance().getRandomInt(enums.length)];
	}
}