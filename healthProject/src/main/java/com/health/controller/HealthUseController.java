package com.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.health.domain.HealthUseVO;
import com.health.service.HealthUseService;
import com.health.service.MemberService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/health")
@Log4j
public class HealthUseController {
   
   @Autowired
   private HealthUseService hservice;

   @Autowired
   private MemberService mservice;

   
   @GetMapping("/healthusebuy")
   public void buy() {
      
   }
   
   @PostMapping("/create")
   public String create(String id, String pw,String useRight, RedirectAttributes RA) {
      
      log.info("이용권 생성");
      log.info("아이디 : " + id + ",패스워드 :" + pw + ",사용권 죵류 :" + useRight );
      
      int result = mservice.login(id, pw); // 결제 로그인...
      
      int healthNum = 0; 
      
      if(result == 1) {
         //결제 성공
         RA.addFlashAttribute("msg", "회원권 결제에 성공했습니다.");
         
         //헬스 사용권 정보 등록 정보
         HealthUseVO vo = new HealthUseVO();
         
         if("C".equals(useRight)) {
            vo = new HealthUseVO(healthNum, "이용권 :" + useRight, "2022-11-01", "2022-11-30", 10, id);
         }else if("B".equals(useRight)) {
            vo = new HealthUseVO(healthNum, "이용권 :" + useRight, "2022-10-01", "2022-12-31", 30, id);
         }else if("A".equals(useRight)) {
            vo = new HealthUseVO(healthNum, "이용권 :" + useRight, "2022-07-01", "2022-12-31", 60, id);
         }else if("S".equals(useRight)){
            vo = new HealthUseVO(healthNum, "이용권 :" + useRight, "2022-01-01", "2022-12-31", 120, id);
         }

         log.info("선택한 이용권 :" + vo);
         
         if(hservice.create(vo)) {
            log.info("이용권 생성 성공");
         }

         healthNum++;
         
         //useRight를 이용하여 healthUseVO를 생성 .... 
      }else {
         //결제 실패
         RA.addFlashAttribute("msg", "회원권 결제에 실패했습니다.");
      }
      
      return "redirect:/health/result";
   }


   @RequestMapping("/result")
   public void result() {
         
   }
}