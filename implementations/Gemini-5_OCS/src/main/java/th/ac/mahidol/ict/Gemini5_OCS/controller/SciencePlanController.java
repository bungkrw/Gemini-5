package th.ac.mahidol.ict.Gemini5_OCS.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import th.ac.mahidol.ict.Gemini5_OCS.model.*;
import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.StarSystem;
import org.springframework.web.bind.annotation.*;
import th.ac.mahidol.ict.Gemini5_OCS.repository.ScienceFormRepository;
import th.ac.mahidol.ict.Gemini5_OCS.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller

public class SciencePlanController {
    OCS ocs = new OCS();
    String resultSplit[];
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScienceFormRepository scienceFormRepository;
    @GetMapping("/")
    public String getAllSciencePlans(Model model, Authentication authentication){
        ArrayList<SciencePlan> sciencePlans = ocs.getAllSciencePlans();
        List<ScienceForm> scienceForms = scienceFormRepository.findAll();
        if (!scienceForms.isEmpty()) {
            for (ScienceForm plan : scienceForms) {
                if (plan.isNull(plan)) {
                    plan.setCheckNull(true);
                } else {
                    plan.setCheckNull(false);
                }
            }
            model.addAttribute("plans", scienceForms);
        }

            model.addAttribute("plansOCS", sciencePlans);
        getAuth(model,authentication);
        return "SearchExsistingPlanPage";
    }

    @PostMapping("/createSci")
    @ResponseBody
    public ModelAndView createSciencePlan(@ModelAttribute("newPlan") ScienceForm newPlan,Model model, Authentication authentication){

        System.out.println(newPlan.toString());
        String creator = newPlan.getCreator();
        String submitter = newPlan.getSubmitter();
        Double fundingInUSD = newPlan.getFundingInUSD();
        String objectives = newPlan.getObjectives();
        String starSystem = newPlan.getStarSystem();
        String startDate = newPlan.getStartDate();
        String endDate = newPlan.getEndDate();
        String telescopeLocation = newPlan.getTelescopeLocation().toUpperCase();
        String fileType = newPlan.getFileType();
        String fileQuality = newPlan.getFileQuality();
        String colorType = newPlan.getColorType();
        Double contrast = newPlan.getContrast();
        Double brightness = newPlan.getBrightness();
        Double saturation = newPlan.getSaturation();
        Double highlights = newPlan.getHighlights();
        Double exposure = newPlan.getExposure();
        Double shadows = newPlan.getShadows();
        Double whites = newPlan.getWhites();
        Double blacks = newPlan.getBlacks();
        Double luminance = newPlan.getLuminance();
        Double hue = newPlan.getHue();

        ScienceForm newSciPlan = new ScienceForm();
        newSciPlan.setCreator(creator);
        newSciPlan.setSubmitter(submitter);
        newSciPlan.setFundingInUSD(fundingInUSD);
        newSciPlan.setObjectives(objectives);
        newSciPlan.setStarSystem(starSystem);
        newSciPlan.setStartDate(startDate);
        newSciPlan.setTelescopeLocation(telescopeLocation);
        newSciPlan.setEndDate(endDate);
        newSciPlan.setFileType(fileType);
        newSciPlan.setColorType(colorType);
        newSciPlan.setFileQuality(fileQuality);
        newSciPlan.setContrast(contrast);
        newSciPlan.setBrightness(brightness);
        newSciPlan.setSaturation(saturation);
        newSciPlan.setHighlights(highlights);
        newSciPlan.setExposure(exposure);
        newSciPlan.setShadows(shadows);
        newSciPlan.setWhites(whites);
        newSciPlan.setBlacks(blacks);
        newSciPlan.setLuminance(luminance);
        newSciPlan.setHue(hue);
        newSciPlan.setStatus("CREATED");


        scienceFormRepository.save(newSciPlan);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/SciPlan")
    @ResponseBody
    public List<ScienceForm> getSciencePlan(){
        return scienceFormRepository.findAll();
    }


    @GetMapping("/Edit/{planNo}")
    public String editSciencePlanByNo(Model model,Authentication authentication,@PathVariable("planNo") int planNo){
        getAuth(model,authentication);
        ScienceForm edit = scienceFormRepository.findById(planNo).get();
        model.addAttribute("editPlan",edit);

        return "EditSciencePlanPage";
    }

    @GetMapping("/Submit/{planNo}")
    public ModelAndView submitSciencePlanByNo(@PathVariable("planNo") int planNo){
        ScienceForm plan = scienceFormRepository.findById(planNo).get();
        SciencePlan submitPlan = new SciencePlan();
        String creator = plan.getCreator();
        String submitter = plan.getSubmitter();
        Double fundingInUSD = plan.getFundingInUSD();
        String objectives = plan.getObjectives();
        String starSystem = plan.getStarSystem();
        String startDate = plan.getStartDate();
        String endDate = plan.getEndDate();
        String telescopeLocation = plan.getTelescopeLocation().toUpperCase();
        String fileType = plan.getFileType();
        String fileQuality = plan.getFileQuality();
        String colorType = plan.getColorType();
        Double contrast = plan.getContrast();
        Double brightness = plan.getBrightness();
        Double saturation = plan.getSaturation();
        Double highlights = plan.getHighlights();
        Double exposure = plan.getExposure();
        Double shadows = plan.getShadows();
        Double whites = plan.getWhites();
        Double blacks = plan.getBlacks();
        Double luminance = plan.getLuminance();
        Double hue = plan.getHue();

        // Convert String to Enum
        StarSystem.CONSTELLATIONS star = StarSystem.CONSTELLATIONS.valueOf(starSystem);
        SciencePlan.TELESCOPELOC telescopeloc = SciencePlan.TELESCOPELOC.valueOf(telescopeLocation);


        submitPlan.setCreator(creator);
        submitPlan.setSubmitter(submitter);
        submitPlan.setFundingInUSD(fundingInUSD);
        submitPlan.setObjectives(objectives);
        submitPlan.setStarSystem(star);
        submitPlan.setStartDate(startDate);
        submitPlan.setTelescopeLocation(telescopeloc);
        submitPlan.setEndDate(endDate);

        DataProcRequirement requirement =
                new DataProcRequirement(fileType, fileQuality, colorType,
                        contrast, brightness, saturation, highlights, exposure, shadows,
                        whites, blacks, luminance, hue);
        submitPlan.setDataProcRequirements(requirement);
        ocs.submitSciencePlan(submitPlan);
        scienceFormRepository.deleteById(planNo);

        return new ModelAndView("redirect:/");



    }

    @PostMapping("/Edit/{planNo}")
    @ResponseBody
    public ModelAndView editSciencePlan(@ModelAttribute("editPlan") ScienceForm editPlan,Model model, Authentication authentication,@PathVariable("planNo") int planNo){

        String creator = editPlan.getCreator();
        String submitter = editPlan.getSubmitter();
        Double fundingInUSD = editPlan.getFundingInUSD();
        String objectives = editPlan.getObjectives();
        String starSystem = editPlan.getStarSystem();
        String startDate = editPlan.getStartDate();
        String endDate = editPlan.getEndDate();
        String telescopeLocation = editPlan.getTelescopeLocation().toUpperCase();
        String fileType = editPlan.getFileType();
        String fileQuality = editPlan.getFileQuality();
        String colorType = editPlan.getColorType();
        Double contrast = editPlan.getContrast();
        Double brightness = editPlan.getBrightness();
        Double saturation = editPlan.getSaturation();
        Double highlights = editPlan.getHighlights();
        Double exposure = editPlan.getExposure();
        Double shadows = editPlan.getShadows();
        Double whites = editPlan.getWhites();
        Double blacks = editPlan.getBlacks();
        Double luminance = editPlan.getLuminance();
        Double hue = editPlan.getHue();


        ScienceForm newSciPlan = scienceFormRepository.findById(planNo).get();
        newSciPlan.setCreator(creator);
        newSciPlan.setSubmitter(submitter);
        newSciPlan.setFundingInUSD(fundingInUSD);
        newSciPlan.setObjectives(objectives);
        newSciPlan.setStarSystem(starSystem);
        newSciPlan.setStartDate(startDate);
        newSciPlan.setTelescopeLocation(telescopeLocation);
        newSciPlan.setEndDate(endDate);
        newSciPlan.setFileType(fileType);
        newSciPlan.setColorType(colorType);
        newSciPlan.setFileQuality(fileQuality);
        newSciPlan.setContrast(contrast);
        newSciPlan.setBrightness(brightness);
        newSciPlan.setSaturation(saturation);
        newSciPlan.setHighlights(highlights);
        newSciPlan.setExposure(exposure);
        newSciPlan.setShadows(shadows);
        newSciPlan.setWhites(whites);
        newSciPlan.setBlacks(blacks);
        newSciPlan.setLuminance(luminance);
        newSciPlan.setHue(hue);
        newSciPlan.setStatus("CREATED");

        scienceFormRepository.save(newSciPlan);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/create")
    public String CreateForm(Model model,Authentication authentication)
    {
        ScienceForm newPlan = new ScienceForm();
        model.addAttribute("newPlan", newPlan);
        getAuth(model,authentication);

        return "CreateSciencePlanPage";
    }



    public void getAuth(Model model,Authentication authentication)
    {
        String username = authentication.getName();
        model.addAttribute("username", username);
        // Find the current user to get role
        User currentUser = userRepository.findByUsername(username);
        //System.out.println(currentUser instanceof User);
        model.addAttribute("role", currentUser.getRole());
    }


    @PostMapping("/test/{planNo}")
    @ResponseBody
    public ModelAndView testSciencePlan(@PathVariable("planNo") int planNo, Model model, HttpServletRequest request){


        String result = ocs.testSciencePlan(ocs.getSciencePlanByNo(planNo));
        resultSplit = result.split("\\r?\\n");
        return new ModelAndView("redirect:/test/" + planNo);
    }

    @GetMapping("/test/{planNo}")
    public String TestPage(Model model,Authentication authentication,@PathVariable("planNo") int planNo)
    {
        SciencePlan sciencePlan = ocs.getSciencePlanByNo(planNo);
        model.addAttribute("plan", sciencePlan);
        model.addAttribute("resultTest",resultSplit);
        resultSplit = null;
        getAuth(model,authentication);
        return "TestPage";
    }
}