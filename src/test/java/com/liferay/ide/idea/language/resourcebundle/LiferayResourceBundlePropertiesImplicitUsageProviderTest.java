/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.ide.idea.language.resourcebundle;

import com.intellij.lang.properties.IProperty;
import com.intellij.lang.properties.psi.PropertiesFile;
import com.intellij.lang.properties.psi.Property;
import com.intellij.psi.PsiFile;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;

/**
 * @author Dominik Marks
 */
public class LiferayResourceBundlePropertiesImplicitUsageProviderTest extends BasePlatformTestCase {

	public void testImplicitUsagePropertyInLanguageProperties() {
		PsiFile file = myFixture.configureByFile("Language.properties");

		assertNotNull(file);

		PropertiesFile propertiesFile = (PropertiesFile)file;

		LiferayResourceBundlePropertiesImplicitUsageProvider provider =
			new LiferayResourceBundlePropertiesImplicitUsageProvider();

		for (IProperty property : propertiesFile.getProperties()) {
			Property p = (Property)property;

			String name = property.getName();

			if (name.contains("foo")) {
				assertFalse(name, provider.isUsed(p));
			}
			else {
				assertTrue(name, provider.isUsed(p));
			}
		}
	}

	@Override
	protected String getTestDataPath() {
		return "testdata/com/liferay/ide/idea/language/resourcebundle" +
			"/LiferayResourceBundlePropertiesImplicitUsageProviderTest";
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

}