package com.qf.controller;

        import com.alibaba.dubbo.config.annotation.Reference;
        import com.qf.entity.Classes;
        import com.qf.entity.Student;
        import com.qf.entity.StudentVo;
        import com.qf.service.IClassService;
        import com.qf.service.IStuService;


        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;

        import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {
    @Reference
    private IStuService stuService;

    @Reference
    private IClassService classService;
    @RequestMapping("/show")
    public String showStu(Model model){
        //查询所有学生信息,包括班级id
        List<StudentVo> stuList = stuService.queryAll();

        //通过id查询所有班级信息

        model.addAttribute("stuList",stuList);
        return "index";
    }

    @RequestMapping("/toAdd")
    public String add(Model model){
        List<Classes> classesList = classService.queryList();
        model.addAttribute("classesList",classesList);
        return "add";
    }

    @RequestMapping("/add")
    public String addStu(Student student){
        int result = stuService.insert(student);
        return "redirect:/stu/show";
    }

    //跳转到编辑页面
    @RequestMapping("/editor/{id}")
    public String editor(@PathVariable Integer id, Model model){
        Student student = stuService.selectOne(id);
        List<Classes> classesList = classService.queryList();
        model.addAttribute("classesList",classesList);
        model.addAttribute("student",student);
        return "modify";
    }

    /**
     * 修改
     * @param student
     * @return
     */
    @RequestMapping("/modify")
    public String modify(Student student){
        int result = stuService.update(student);
        return "redirect:/stu/show";

    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        int result = stuService.delete(id);
        return "redirect:/stu/show";
    }
}
