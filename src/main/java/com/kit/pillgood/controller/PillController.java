package com.kit.pillgood.controller;

import com.kit.pillgood.common.ResponseFormat;
import com.kit.pillgood.exeptions.exeption.NonExistsPillIndexException;
import com.kit.pillgood.exeptions.exeption.NonExistsPillNameException;
import com.kit.pillgood.persistence.dto.PillDTO;
import com.kit.pillgood.persistence.dto.SearchingConditionDTO;
import com.kit.pillgood.persistence.dto.ValidationGroups;
import com.kit.pillgood.service.PillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pill")
public class PillController {
    private final PillService pillService;

    @Autowired
    public PillController(PillService pillService) {
        this.pillService = pillService;
    }

    @GetMapping("/search/pill-index/{pill-index}")
    public ResponseEntity<ResponseFormat> getPillByPillIndex(@PathVariable(name="pill-index") Long pillIndex) throws NonExistsPillIndexException {
        ResponseFormat responseFormat = ResponseFormat.of("성공 코드", HttpStatus.OK.value(), pillService.searchPillByPillIndex(pillIndex));
        return new ResponseEntity<>(responseFormat, HttpStatus.OK);
    }

    @GetMapping("/search/pill-name/{pill-name}")
    public ResponseEntity<ResponseFormat> getPillByPillName(@PathVariable(name="pill-name") String pillName) throws NonExistsPillNameException {
        ResponseFormat responseFormat = ResponseFormat.of("성공 코드", HttpStatus.OK.value(), pillService.searchPillByPillName(pillName));
        return new ResponseEntity<>(responseFormat, HttpStatus.OK);
    }

    @GetMapping("/search/pills")
    public ResponseEntity<ResponseFormat> getSearchingPills(@ModelAttribute @Validated(ValidationGroups.groupSearch.class) SearchingConditionDTO searchingConditionDTO) {
        ResponseFormat responseFormat = ResponseFormat.of("성공 코드", HttpStatus.OK.value(), pillService.searchPillByAttributesOfPill(searchingConditionDTO));
        return new ResponseEntity<>(responseFormat, HttpStatus.OK);
    }
}
