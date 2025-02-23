package org.bbottema.loremipsumobjects.typefactories;

import org.bbottema.loremipsumobjects.ClassUsageInfo;
import org.bbottema.loremipsumobjects.LoremIpsumConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomFactoryFactory<T> extends LoremIpsumObjectFactory<T> {
	private static final Random RANDOM = new Random();
	private final Class<?> clazz;
	private final List<LoremIpsumObjectFactory<?>> factories;

	public RandomFactoryFactory(@NotNull Class<Number> clazz, @NotNull LoremIpsumObjectFactory<?>... factories) {
		this.clazz = clazz;
		this.factories = Arrays.asList(factories);
	}

	@Override
	public boolean isValidForType(Class<? super T> clazz) {
		return clazz == this.clazz;
	}

	@Nullable
	@Override
	@SuppressWarnings("unchecked")
	public T _createLoremIpsumObject(@Nullable Type[] genericMetaData, @Nullable Map<String, ClassUsageInfo<?>> knownInstances, LoremIpsumConfig loremIpsumConfig, @Nullable List<Exception> exceptions) {
		return (T) factories.get(RANDOM.nextInt(factories.size()))
				.createLoremIpsumObject(genericMetaData, knownInstances, loremIpsumConfig, exceptions);
	}
}
