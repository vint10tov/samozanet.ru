//package ru.samozanet.controllers;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import ru.samozanet.services.PriceService;
//
//@Controller
//@RequiredArgsConstructor
//public class PriceController {
//
//    private final PriceService priceService;
//
//    @GetMapping("/services")
//    public String servicesGet() {
//        return "services";
//    }
//
//    @GetMapping("/services/price-electrician") // Прайс на электромонтажные работы
//    public String priceElectrician(Model model) {
//        model.addAttribute("price", priceService.listPriceElectrician());
//        return "price";
//    }
//    @GetMapping("/services/price-finishing") // Прайс на отделочные работы
//    public String priceFinishing(Model model) {
//        model.addAttribute ("price", priceService.listPriceFinishing());
//        return "price";
//    }
//    @GetMapping("/services/price-plumbing") // Прайс на сантехнические работы
//    public String pricePlumbing(Model model) {
//        model.addAttribute("price", priceService.listPricePlumbing());
//        return "price";
//    }
//    @GetMapping("/services/price-air-conditioners") // Прайс на установку сплит систем
//    public String priceAirConditioners(Model model) {
//        model.addAttribute("price", priceService.listPriceAirConditioners());
//        return "price";
//    }
//    @GetMapping("services/price-design") // Прайс на проектирование
//    public String priceDesign(Model model) {
//        model.addAttribute("price", priceService.listPriceDesign());
//        return "price";
//    }
//}