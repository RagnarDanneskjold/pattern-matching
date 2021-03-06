package com.aptima.netstorm.algorithms.aptima.bp.mismatch;

/**Class is a processor that checks for equality in the attributes between model and data elements
 * 
 * @author Aptima
 *
 */
public class EqualIntegerProcessor extends DefaultAttributeMismatchProcessor {

	/**Method gets the mismatch in double format between a model constraint and a data value
	 * 
	 * @param modelConstraint				String that specifies the model attribute of interest
	 * @param dataValue						String that specifies the data value of interest
	 * 
	 * @return								double that holds the mismatch between the two
	 */
	public double getMismatch(String modelConstraint, String dataValue) {
		
		// parse out of equality + data string
		// parse out of equality + data string
		String[] modelConstraintParts = modelConstraint.split(AttributeConstraintVocab.EQUAL_TO.toString());
		String modelValue = modelConstraintParts[1];
		
		double mm = super.processSimpleCases(modelValue, dataValue);

		if (mm >= 0.0)
			return mm;

		// process the model vs. data value in equality case
		double dModelValue = Double.parseDouble(modelValue);
		double dDataValue = Double.parseDouble(dataValue);

		if (dModelValue == dDataValue) { // perfect match
			return 0.0;
		} else {
			double diff = dDataValue - dModelValue;

			// penalty for above or below model value
			diff = Math.abs(diff);
			Double norm = 4.0 * Math.abs((double) dModelValue / 10.0);
			return Math.min((double) diff / norm, 1);
		}
	}

	/**Method that is the same as getMismatch except takes in string arrays along with an index of the
	 * element of interest
	 * Returns a value between 0 and 1. 0 = perfect match, 1 = maximum mismatch.
	 * 
	 * @param modelVals				String array of all of the model values					
	 * @param dataVals				String array of all the data values
	 * @param index					Integer index of the values within the arrays to be compared
	 * @param rangeUsed				Unused boolean variable
	 * @return						double that is the mismatch between the model and data elements
	 */
	public static double getMismatchE(String[] modelVals, String[] dataVals, int index, boolean rangeUsed) {

		String modelValue = modelVals[index];
		String dataValue = dataVals[index];

		return (new EqualIntegerProcessor()).getMismatch(modelValue, dataValue);
	}

//	public static void main(String[] args) throws Exception {
//		test();
//	}

//	public static void test() {
//
//		// test greater than or equal to cases
//		String[] modelVals = new String[1];
//		String[] dataVals = new String[1];
//
//		modelVals[0] = DegreeEqualityEnumeration.EQUAL_TO.toString() + AttributeProcessor.equalitySeperator + "0";
//		System.out.println(modelVals[0]);
//
//		System.out.println(AttributeProcessor.getDegreeFromString(modelVals[0]));
//		System.out.println(AttributeProcessor.getDegreeEqualityFromString(modelVals[0]));
//		
//		dataVals[0] = "0";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "1";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "2";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "3";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "4";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//
//		modelVals[0] = "1";
//		System.out.println(modelVals[0]);
//
//		dataVals[0] = "0";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "1";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "2";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "3";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "4";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//
//		modelVals[0] = "2";
//		System.out.println(modelVals[0]);
//
//		dataVals[0] = "0";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "1";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "2";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "3";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "4";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//
//		modelVals[0] = "3";
//		System.out.println(modelVals[0]);
//
//		dataVals[0] = "0";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "1";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "2";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "3";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "4";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "5";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "6";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		
//		modelVals[0] = "4";
//		System.out.println(modelVals[0]);
//
//		dataVals[0] = "-1";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "-2";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "0";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "1";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "2";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "3";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "4";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "5";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "6";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		dataVals[0] = "7";
//		System.out.println("(" + dataVals[0] + ") " + getMismatchE(modelVals, dataVals, 0, false));
//		
//		System.out.println("");
//
//	}
}
