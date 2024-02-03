class SY2022bit041 {

    public static void main(String[] args) {
        // Test your logic here
        String[] registrations = {};
        SY2022bit041 cm = new SY2022bit041();
        int validCount = cm.getValidRegistrationsCount(registrations);
        System.out.println(validCount);
    }

    public int getValidRegistrationsCount(String[] registrations) {
       // Invalid input
        if (registrations == null) {
            return -1; 
        }

        int validCountRegNo = 0;
        for (String regNo : registrations) {
            if (isValidRegistration(regNo)) {
                validCountRegNo++;
            }
        }
        return validCountRegNo;
    }

    public boolean isValidRegistration(String inputRegNo) {
        if (inputRegNo.length() != 10) {
            return false;
        }

        int admissionYear = Integer.parseInt(inputRegNo.substring(0, 4));
        String inputBranchCode = inputRegNo.substring(4, 7);
        char degreeChar = inputRegNo.charAt(5);

        
        if ((isValidYear(admissionYear)) && (degreeChar == 'b') &&
                (isValidBranch(inputBranchCode)) && (isValidSerialNo(inputRegNo))) {
           
            return true;
        }

        return false;
    }
    
 //Checks if the year is between 2000 and 2024
    public boolean isValidYear(int year) {
        return year >= 2000 && year <= 2024;
    }
    
    /*Checks if the brnchCode is valid or not
     Valid departments: bit, bcs, bme, bch */
    public boolean isValidBranch(String branchCode) {
        return branchCode.equalsIgnoreCase("it") || branchCode.equalsIgnoreCase("cs")
                || branchCode.equalsIgnoreCase("me") || branchCode.equalsIgnoreCase("ch");
    }
    
    //Checks whether the 3 digit serial number contains all integer digits
    public boolean isValidSerialNo(String inputRegNo){
            for (int i = 7; i < inputRegNo.length(); i++) {
                if (!Character.isDigit(inputRegNo.charAt(i))) {
                    return false;
                }
            }
            return true;
    }
}

