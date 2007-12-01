package org.zlibrary.core.options;

import org.zlibrary.core.options.util.*;

/**
 * ����� ����� �� ��������� �� ����������� ������
 * �������� ������ "������", "����" � "�� ����".
 * @author �������������
 *
 */
public final class ZLBoolean3Option extends ZLSimpleOption {

    private	ZLBoolean3 myValue;
	private	final ZLBoolean3 myDefaultValue;
	
	public ZLBoolean3Option(String category, String group, String optionName, ZLBoolean3 defaultValue) {	 
		super(category, group, optionName);
		myDefaultValue = defaultValue;
		myValue = myDefaultValue;
	}
	
	public ZLOptionType getType() {
		return ZLOptionType.TYPE_BOOLEAN3;
	}
	
	public ZLBoolean3 getValue() {
		if (!myIsSynchronized) {
			String value = myConfig.getValue(myGroup, myOptionName, 
                    myDefaultValue.toString());
			myValue = ZLFromStringConverter.getBoolean3Value(value);
			myIsSynchronized = true;
		}
		return myValue;
	}
	
	public void setValue(ZLBoolean3 value) {
		if (myIsSynchronized && (myValue == value)) {
			return;
		}
		myValue = value;
		myIsSynchronized = true;
		if (myValue == myDefaultValue) {
			myConfig.unsetValue(myGroup, myOptionName);
		} else {
			myConfig.setValue(myOptionName, myGroup, myValue.toString(), myCategory);
		}
	}
}