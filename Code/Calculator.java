import cs1.Keyboard;

public class Calculator {

    //Instance vars

    //methods

    //BMI (Body Mass Index)
    public static int BMI( int weight, int height) {
        return 703 * weight / ( height * height );
    }

    //BMI range
    public static String BMIRange( int BMI ) {
	if (BMI > 40)
	    return "Very Severely Obese";
	if (BMI >= 35)
	    return "Severely Obese";
	if (BMI >= 30)
	    return "Moderately Obese";
	if (BMI >= 25)
	    return "Overweight";
	if (BMI >= 18.5)
	    return "Normal (healthy) weight";
	return "Underweight";
    }
    
    //BMR (Body Metabolic Rate) calculator
    public static int BMR( String sex, int age, int weight, int height ) {
        double BMR = 0;
	if (sex.equals("female"))
	    BMR = 655 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
	if (sex.equals("male"))
	    BMR = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * age);
	return (int) BMR;
    }

    //Daily calorie intake calculator
    public static int calIntake( double BMR, int exercise ) {
        double cals = 0;
	if (exercise == 1)
	    cals = BMR * 1.2;
	else if (exercise == 2)
	    cals = BMR * 1.375;
	else if (exercise == 3)
	    cals = BMR * 1.55;
	else if (exercise == 4)
	    cals = BMR * 1.725;
	else if (exercise == 5)
	    cals = BMR * 1.9;
	return (int) cals;
    }

    //Teas per day calculator (about 100 calories burned a day, ~2.5 cups)
    public static int days( int pounds ) {
	int calsToBurn = pounds * 3500;
	int days = calsToBurn / 100;
	return days;
    }
    
    //main
    public static void main(String[] args) {

	String sex;
	sex = Keyboard.readString();

	int age;
	age = Keyboard.readInt();
	
	int weight;
	weight = Keyboard.readInt();

	int height;
	height = Keyboard.readInt();

	int exercise;
	exercise = Keyboard.readInt();

	int pounds;
	pounds = Keyboard.readInt();

	int bmi = BMI( weight, height );
	int bmr = BMR( sex, age, weight, height );
	
	System.out.println(bmi);
	System.out.println( BMIRange( bmi ) );
	System.out.println(bmr);
	System.out.println( calIntake( bmr, exercise ) );
	System.out.println( days( pounds ) );
	
    }
    
}//end
