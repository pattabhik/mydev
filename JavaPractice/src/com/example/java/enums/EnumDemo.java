package com.example.java.enums;

/**
 * @author Pattabhi
 *
 */
public class EnumDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		switch (ContainerTypeEnum.DRY) {
		case DRY:
			System.out.println("DRY");
			break;
		case REEFER:
			System.out.println("REEFER");
			break;
		}
	}

}
