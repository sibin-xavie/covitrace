package com.jea.medico.exception;
/** 
* 
* @author Sibin 
* @since 14 sep 2020 9.45 AM
*/
public class PatientException extends Exception {

    public PatientException(String messageOfException) {
        super(messageOfException);
    }

    public static void checkNull(Object obj) throws PatientException {

        if (obj == null) {
            throw new PatientException("Object is null");

        } else {

            throw new PatientException("Object is Created");
        }

    }
    
 
}
