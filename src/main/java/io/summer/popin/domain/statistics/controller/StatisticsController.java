package io.summer.popin.domain.statistics.controller;

import io.summer.popin.domain.statistics.service.StatisticsService;
import io.summer.popin.domain.statistics.vo.StatisticsHostVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;



@Controller
@RequiredArgsConstructor
@Slf4j
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/juntest/{hostNo}")
    public List<StatisticsHostVO> individualStatistics(@PathVariable Integer hostNo){
        List<StatisticsHostVO> list =  statisticsService.showStatistics(hostNo);
        return statisticsService.showStatistics(1);
    }

    @GetMapping("/statistics")
    public String test(){
        return "test";
    }



}
