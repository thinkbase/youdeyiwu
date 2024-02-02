package com.youdeyiwu.controller.point;

import com.youdeyiwu.model.dto.point.SavePointAutoRuleDto;
import com.youdeyiwu.model.dto.point.SavePointRuleDto;
import com.youdeyiwu.model.vo.PageVo;
import com.youdeyiwu.model.vo.point.PointAutoRuleEntityVo;
import com.youdeyiwu.model.vo.point.PointHistoryEntityVo;
import com.youdeyiwu.model.vo.point.PointRuleEntityVo;
import com.youdeyiwu.service.point.PointService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * point.
 *
 * @author dafengzhen
 */
@RequiredArgsConstructor
@RequestMapping(value = "/points")
@RestController
public class PointController {

  private final PointService pointService;

  @PostMapping(value = "/auto-rules")
  public ResponseEntity<Void> save(@Valid @RequestBody SavePointAutoRuleDto dto) {
    pointService.save(dto);
    return ResponseEntity.ok().build();
  }

  @PostMapping(value = "/rules")
  public ResponseEntity<Void> save(@Valid @RequestBody SavePointRuleDto dto) {
    pointService.save(dto);
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/auto-rules")
  public ResponseEntity<List<PointAutoRuleEntityVo>> queryAutoRules() {
    return ResponseEntity.ok().body(pointService.queryAutoRules());
  }

  @GetMapping(value = "/rules")
  public ResponseEntity<List<PointRuleEntityVo>> queryRules() {
    return ResponseEntity.ok().body(pointService.queryRules());
  }

  @GetMapping(value = "/histories")
  public ResponseEntity<PageVo<PointHistoryEntityVo>> queryAll(
      @PageableDefault(size = 15)
      @SortDefault(value = {"id"}, direction = Sort.Direction.DESC)
      Pageable pageable
  ) {
    return ResponseEntity.ok().body(pointService.queryAll(pageable));
  }
}