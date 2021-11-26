package th.ac.mahidol.ict.Gemini5_OCS;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.example.MySciencePlan;
import edu.gemini.app.ocs.model.AstronomicalData;
import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.StarSystem;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Gemini5OcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Gemini5OcsApplication.class, args);
		OCS ocs = new OCS();
	}

}
