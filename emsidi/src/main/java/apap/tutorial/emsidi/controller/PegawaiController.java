package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalTime;
import java.util.List;

@Controller
public class PegawaiController {
    @Qualifier("pegawaiServiceImpl")
    @Autowired
    PegawaiService pegawaiService;

    @Qualifier("cabangServiceImpl")
    @Autowired
    CabangService cabangService;

    @GetMapping("/pegawai/add/{noCabang}")
    public String addPegawaiForm(@PathVariable long noCabang, Model model){
        PegawaiModel pegawai = new PegawaiModel();
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        pegawai.setCabang(cabang);
        model.addAttribute("noCabang", noCabang);
        model.addAttribute("pegawai", pegawai);
        return "form-add-pegawai";
    }

    @PostMapping("/pegawai/add")
    public String addPegawaiSubmit(
            @ModelAttribute PegawaiModel pegawai,
            Model model
    ){
        pegawaiService.addPegawai(pegawai);
        model.addAttribute("noCabang", pegawai.getCabang().getNoCabang());
        model.addAttribute("namaPegawai", pegawai.getNamaPegawai());
        return "add-pegawai";
    }

    @DateTimeFormat(pattern = "HH:mm")
    @GetMapping("/pegawai/update/{noPegawai}")
    public String updatepegawaiForm(
            @PathVariable long noPegawai,
            Model model
    ) {
        PegawaiModel pegawai = pegawaiService.getPegawaiByNoPegawai(noPegawai);
        CabangModel cabang = pegawai.getCabang();
        LocalTime now = LocalTime.now();

        if(now.isAfter(cabang.getWaktuTutup()) || now.isBefore(cabang.getWaktuBuka())){
            model.addAttribute("pegawai", pegawai);
            return "form-update-pegawai";
        }
        return "errorPage";
    }

    @PostMapping("/pegawai/update")
    public String updatePegawaiSubmit(
            @ModelAttribute PegawaiModel pegawai,
            Model model
    ) {
        pegawaiService.updatePegawai(pegawai);
        model.addAttribute("noPegawai", pegawai.getNoPegawai());
        return "update-pegawai";
    }

    @DateTimeFormat(pattern = "HH:mm")
    @GetMapping("/pegawai/delete/{noPegawai}")
    public String deletePegawaiSubmit(
            @PathVariable long noPegawai,
            Model model
    ) {
        PegawaiModel pegawai = pegawaiService.getPegawaiByNoPegawai(noPegawai);
        CabangModel cabang = pegawai.getCabang();
        LocalTime now = LocalTime.now();
        List<PegawaiModel> listPegawai = cabang.getListPegawai();

        model.addAttribute("cabang", cabang);
        model.addAttribute("listPegawai", listPegawai);

        if(now.isAfter(cabang.getWaktuTutup()) || now.isBefore(cabang.getWaktuBuka())){
            pegawaiService.deletePegawai(pegawai);
            return "view-cabang";
        }
        return "errorPage";
    }
}
