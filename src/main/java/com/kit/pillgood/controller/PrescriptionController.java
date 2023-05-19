package com.kit.pillgood.controller;

import com.kit.pillgood.exeptions.exeption.NonRegistrationGroupException;
import com.kit.pillgood.persistence.dto.PrescriptionAndDiseaseNameDTO;
import com.kit.pillgood.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("/search/{group-member-index}")
    public List<PrescriptionAndDiseaseNameDTO> getPrescriptionsByGroupMemberIndex(@PathVariable(name="group-member-index") Long groupMemberIndex) throws NonRegistrationGroupException {
        return prescriptionService.searchGroupMemberPrescriptionsByGroupMemberIndex(groupMemberIndex);
    }

//    @PostMapping("/create/image-upload")
//    public PrescriptionDTO createPrescriptionByImage(@RequestParam Long userIndex,
//                                                     @RequestParam Long groupMemberIndex,
//                                                     @ModelAttribute MultipartFile prescriptionImage) {
//        return prescriptionService.createPrescription(userIndex, groupMemberIndex, prescriptionImage);
//    }

    @DeleteMapping("/delete/{prescription-index}")
    public void deletePrescriptionByPrescriptionIndex(@PathVariable(name="prescription-index") Long prescriptionIndex) {
        prescriptionService.deletePrescription(prescriptionIndex);
    }
}
