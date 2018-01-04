package cn.happy.day12validator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by Administrator on 2017/11/7.
 */
@Controller
public class FirstController {
    @RequestMapping("/first")
    public String doFirst(@Valid UserInfo info, BindingResult br, Model model){
        //1.判定br中错误总数>0,肯定在模型中至少有一个属性是验证失败的
        if (br.getErrorCount()>0){
            //模型验证失败
            FieldError score=br.getFieldError("score");
            FieldError phone=br.getFieldError("phone");
            FieldError name=br.getFieldError("name");
            FieldError birthday=br.getFieldError("birthday");

            //2.根据FieldError获取到错误信息
            if (score!=null){
                String scoremsg=score.getDefaultMessage();
                model.addAttribute("scoremsg",scoremsg);
            }
            if (phone!=null){
                String phonemsg=phone.getDefaultMessage();
                model.addAttribute("phonemsg",phonemsg);
            }
            if (name!=null){
                String namemsg=name.getDefaultMessage();
                model.addAttribute("namemsg",namemsg);
            }
            if (birthday!=null){
                String birthdaymsg=birthday.getDefaultMessage();
                model.addAttribute("birthdaymsg",birthdaymsg);
            }
            return "/validator.jsp";
        }
        return "/first.jsp";
    }

}
