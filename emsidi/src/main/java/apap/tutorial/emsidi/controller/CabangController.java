package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.MenuModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

@Controller
public class CabangController {

    @Qualifier("cabangServiceImpl")
    @Autowired
    private CabangService cabangService;

    @Qualifier("menuServiceImpl")
    @Autowired
    private MenuService menuService;

    @GetMapping("/cabang/add")
    public String addCabangForm(Model model) {
        List<String> list = new ArrayList<>();
        list.add(" ");
        List<MenuModel> menus = menuService.getListMenu();
        CabangModel cabang = new CabangModel();
        System.out.println(list);
        model.addAttribute("cabang", cabang);
        model.addAttribute("menus", menus);
        model.addAttribute("list", list);
        return "form-add-cabang";
    }

    @GetMapping("/cabang/add/menu")
    public String addCabangForm(Model model, List<String> list){
        List<MenuModel> menus = menuService.getListMenu();
        CabangModel cabang = new CabangModel();
        System.out.println(list);
        model.addAttribute("cabang", cabang);
        model.addAttribute("menus", menus);
        model.addAttribute("list", list);
        return "form-add-cabang";
    }

    @GetMapping("/addmenu")
    public String addAdditionalMenu(
            @RequestParam(value = "list") List<String> list, Model model
    ){
        list.add(" ");
        return addCabangForm(model, list);
    }

    @GetMapping("/removemenu")
    public String removeAdditionalMenu(
            @RequestParam(value = "list") List<String> list, Model model
    ){
        list.remove(list.size()-1);
        return addCabangForm(model, list);
    }

    @PostMapping("/cabang/add")
    public String addCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ) {
        cabangService.addCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "add-cabang";
    }

    @GetMapping("/cabang/viewall")
    public String listCabang(Model model) {
        List<CabangModel> listCabang = cabangService.getCabangList();

        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang";
    }

    @GetMapping("/cabang/view")
    public String viewDetailCabang(
            @RequestParam(value = "noCabang") Long noCabang,
            Model model
    ) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        List<PegawaiModel> listPegawai = cabang.getListPegawai();
        List<MenuModel> listMenu = cabang.getListMenu();

        model.addAttribute("cabang", cabang);
        model.addAttribute("listPegawai", listPegawai);
        model.addAttribute("listMenu", listMenu);

        return "view-cabang";
    }

    @GetMapping("/cabang/update/{noCabang}")
    public String updatecabangForm(
            @PathVariable Long noCabang,
            Model model
    ) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        model.addAttribute("cabang", cabang);
        return "form-update-cabang";
    }

    @PostMapping("/cabang/update")
    public String updateCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ) {
        cabangService.updateCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "update-cabang";
    }

    @DateTimeFormat(pattern = "HH:mm")
    @GetMapping("/cabang/delete/{noCabang}")
    public String deleteCabangSubmit(
            @PathVariable Long noCabang,
            Model model
    ) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        List<PegawaiModel> listPegawai = cabang.getListPegawai();
        LocalTime now = LocalTime.now();

        if(listPegawai.size() == 0){
            if(now.isAfter(cabang.getWaktuTutup()) || now.isBefore(cabang.getWaktuBuka())){
                cabangService.deleteCabang(cabang);
                return "home";
            }
            return "errorPage";
        }
        return "errorPage";
    }
}
