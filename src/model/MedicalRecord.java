package model;

public class MedicalRecord {
    private String diagnosis;
    private final boolean inHospital;

    public MedicalRecord(String diagnosis, boolean inHospital) {
        setDiagnosis(diagnosis);
        this.inHospital = inHospital;
    }

    public void setDiagnosis(String diagnosis) {
        if (diagnosis == null || diagnosis.isBlank()) {
            this.diagnosis = "Not defined";
        } else {
            this.diagnosis = diagnosis;
        }
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public boolean isInHospital() {
        return inHospital;
    }

    @Override
    public String toString() {
        return "Diagnosis: " + diagnosis + ", In hospital: " + inHospital;
    }
}
