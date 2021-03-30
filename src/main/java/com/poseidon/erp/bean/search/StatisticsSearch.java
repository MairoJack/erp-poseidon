package com.poseidon.erp.bean.search;

import com.poseidon.erp.common.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
public class StatisticsSearch {
    @DateTimeFormat(pattern = Constants.DATE)
    private LocalDate startDate;

    @DateTimeFormat(pattern = Constants.DATE)
    private LocalDate endDate;

}
