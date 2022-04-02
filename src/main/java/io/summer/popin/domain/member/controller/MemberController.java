package io.summer.popin.domain.member.controller;

import io.summer.popin.domain.member.dto.ProfileUpdateDTO;
import io.summer.popin.domain.member.dto.ProfileResponseDTO;
import io.summer.popin.domain.member.service.MemberService;
import io.summer.popin.global.dao.UrlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Slf4j
@Controller
public class MemberController {

    private final MemberService memberService;
    private final UrlMapper urlMapper;

//        @GetMapping("/login")
//        public void login() {
//
//
////            return "";
//        }

        @GetMapping("/members/{memberNo}")
        public String getProfile(@PathVariable("memberNo") Long memberNo, Model model) {

            ProfileResponseDTO profile = memberService.findProfileByMemberNo(memberNo);
            String profileImgUrl = urlMapper.findOneByMemberNo(memberNo);

            model.addAttribute("profile", profile);
            model.addAttribute("profileImgUrl", profileImgUrl);
            return "profile";
        }

        @GetMapping("/profile/edit/{memberNo}")  //프로필 수정 폼
        public String showEditProfileForm(@PathVariable("memberNo") Long memberNo, Model model) {

            String profileImgUrl = urlMapper.findOneByMemberNo(memberNo);
            ProfileUpdateDTO profileUpdateDTO = memberService.getEditProfileFormData(memberNo);

            model.addAttribute("profileImgUrl", profileImgUrl);
            model.addAttribute("profileUpdateDTO", profileUpdateDTO);
            return "update-profile";
        }

        @PostMapping("/profile/edit/{memberNo}")  //프로필 수정 요청
        public String updateProfile(@PathVariable("memberNo") Long memberNo, @ModelAttribute ProfileUpdateDTO profileUpdateDTO) {

            memberService.updateProfile(memberNo, profileUpdateDTO);

            log.info("ProfileEditResponseDTO = {}", profileUpdateDTO);
            return "redirect:/members/{memberNo}";
        }












}
