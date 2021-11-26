package th.ac.mahidol.ict.Gemini5_OCS.model;


import edu.gemini.app.ocs.model.DataProcRequirement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ScienceForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int planNo;
    private String creator ;
    private String submitter;
    private Double fundingInUSD;
    private String objectives ;
    private String starSystem ;
    private String startDate ;
    private String endDate;
    private String telescopeLocation ;
    private DataProcRequirement data;
    private String fileType;
    private String fileQuality ;
    private String colorType ;
    private Double contrast  ;
    private Double brightness ;
    private Double saturation  ;
    private Double highlights  ;
    private Double exposure  ;
    private Double shadows  ;
    private Double whites  ;
    private Double blacks  ;
    private Double luminance  ;
    private Double hue  ;
    private String status;
    private boolean checkNull;

    public boolean isNull(ScienceForm plan) {
        if ( !plan.getCreator().isEmpty() &&  !plan.getSubmitter().isEmpty() && plan.getFundingInUSD() != null && !plan.getObjectives().isEmpty() && !plan.getStarSystem().isEmpty() && !plan.getStartDate().isEmpty() && !plan.getEndDate().isEmpty() &&  !plan.getTelescopeLocation().isEmpty()) {
            if ( !plan.getFileType().isEmpty() && !plan.getFileQuality().isEmpty() &&  !plan.getColorType().isEmpty() && plan.getContrast() != null &&  plan.getBrightness() != null&&  plan.getSaturation() != null && plan.getHighlights() != null&& plan.getExposure() != null&& plan.getShadows() != null&& plan.getWhites() != null&& plan.getBlacks() != null&& plan.getLuminance() != null&& plan.getHue() != null)
            {
                return false;
            }
        }
        return true;
    }

    public boolean isCheckNull() {
        return checkNull;
    }

    public void setCheckNull(boolean checkNull) {
        this.checkNull = checkNull;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPlanNo() {
        return planNo;
    }

    public void setPlanNo(int planNo) {
        this.planNo = planNo;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public void setFundingInUSD(Double fundingInUSD) {
        this.fundingInUSD = fundingInUSD;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public void setStarSystem(String starSystem) {
        this.starSystem = starSystem;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setTelescopeLocation(String telescopeLocation) {
        this.telescopeLocation = telescopeLocation;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setFileQuality(String fileQuality) {
        this.fileQuality = fileQuality;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public void setContrast(Double contrast) {
        this.contrast = contrast;
    }

    public void setBrightness(Double brightness) {
        this.brightness = brightness;
    }

    public void setSaturation(Double saturation) {
        this.saturation = saturation;
    }

    public void setHighlights(Double highlights) {
        this.highlights = highlights;
    }

    public void setExposure(Double exposure) {
        this.exposure = exposure;
    }

    public void setShadows(Double shadows) {
        this.shadows = shadows;
    }

    public void setWhites(Double whites) {
        this.whites = whites;
    }

    public void setBlacks(Double blacks) {
        this.blacks = blacks;
    }

    public void setLuminance(Double luminance) {
        this.luminance = luminance;
    }

    public void setHue(Double hue) {
        this.hue = hue;
    }

    @Override
    public String toString() {
        return "ScienceForm{" +
                "creator='" + creator + '\'' +
                ", submitter='" + submitter + '\'' +
                ", fundingInUSD=" + fundingInUSD +
                ", objectives='" + objectives + '\'' +
                ", starSystem='" + starSystem + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", telescopeLocation='" + telescopeLocation + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileQuality='" + fileQuality + '\'' +
                ", colorType='" + colorType + '\'' +
                ", contrast=" + contrast +
                ", brightness=" + brightness +
                ", saturation=" + saturation +
                ", highlights=" + highlights +
                ", exposure=" + exposure +
                ", shadows=" + shadows +
                ", whites=" + whites +
                ", blacks=" + blacks +
                ", luminance=" + luminance +
                ", hue=" + hue +
                ", status=" + status +
                '}';
    }


    public String getCreator() {
        return creator;
    }

    public String getSubmitter() {
        return submitter;
    }

    public Double getFundingInUSD() {
        return fundingInUSD;
    }

    public String getObjectives() {
        return objectives;
    }

    public String getStarSystem() {
        return starSystem;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getTelescopeLocation() {
        return telescopeLocation;
    }

    public String getFileType() {
        return fileType;
    }

    public String getFileQuality() {
        return fileQuality;
    }

    public String getColorType() {
        return colorType;
    }

    public Double getContrast() {
        return contrast;
    }

    public Double getBrightness() {
        return brightness;
    }

    public Double getSaturation() {
        return saturation;
    }

    public Double getHighlights() {
        return highlights;
    }

    public Double getExposure() {
        return exposure;
    }

    public Double getShadows() {
        return shadows;
    }

    public Double getWhites() {
        return whites;
    }

    public Double getBlacks() {
        return blacks;
    }

    public Double getLuminance() {
        return luminance;
    }

    public Double getHue() {
        return hue;
    }
}
