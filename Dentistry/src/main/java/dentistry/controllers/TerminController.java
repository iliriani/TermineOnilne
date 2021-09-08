package dentistry.controllers;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dentistry.model.Pacient;
import dentistry.model.Termin;
import dentistry.model.User;
import dentistry.service.PacientService;
import dentistry.service.TerminService;

@Controller
public class TerminController {

	static Model model;

	@Autowired
	TerminService terminService;
	@Autowired
	PacientService pacientService;


	@RequestMapping(value = "/terminView", method = { RequestMethod.GET, RequestMethod.POST })
	public String hapeTerminet(Model model) {

		this.model = model;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateString = format.format( new Date()   );
		try {
			Date date = format.parse("2019-12-20 18:00:00");
//			model.addAttribute("termins", terminService.gjejSipasDates("2019-04-29"));
			model.addAttribute("termins", terminService.getAllTermins());

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
//		this.model = model;
//		model.addAttribute("termins", terminService.getAllTermins());
		return "terminView";
	}

	@PostMapping("/termins")
	public String hape(Model model, @RequestParam(defaultValue = "") String koha) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateString = format.format( new Date()   );
		try {
			Date date = format.parse("2019-04-29 " + koha);
			model.addAttribute("termins", terminService.gjejSipasDates("2019-04-29"));

		} catch (ParseException e) {
			e.printStackTrace();
		}
//		long id = Long.parseLong(name);
//		model.addAttribute("user", new User());
		return "terminView";
	}

	@PostMapping("/saveTermin")
	public String shtoTermin(@RequestParam String emri_pacientit, @RequestParam String data,
			@RequestParam String koha) {

		System.out.println("Ka hy ne metod " + emri_pacientit);

		List<Pacient> pacienti = pacientService.getPacientByName(emri_pacientit);
		Pacient p = pacienti.get(0);
		System.out.println(p.getEmri() + " " + p.getId());


		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {

			String data_String=data+" "+koha+":00";
			Date date = format.parse(data_String);
			System.out.println(date);

			Termin termin = new Termin(date, p.getId());
			terminService.shtoTermin(termin);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return "redirect:/terminView";
	}

	@PostMapping("/newTerminForm")
	public String newTermin() {

		return "newTermin";
	}
}