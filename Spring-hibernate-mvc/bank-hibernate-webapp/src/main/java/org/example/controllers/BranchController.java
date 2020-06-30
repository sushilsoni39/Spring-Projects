package org.example.controllers;

import org.example.dao.BranchDao;
import org.example.model.Branch;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("/branch")
public class BranchController {
    private BranchDao branchDao;

    public BranchController() {
        branchDao = new BranchDao();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/config.xml");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<Branch> getAllBranches() {
        return branchDao.read();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody Branch addBranch(@RequestBody Branch branch) {
        return branchDao.create(branch);
    }

    @RequestMapping(value="/delete",method = RequestMethod.DELETE)
    public @ResponseBody String deleteBranch(@RequestBody String branchIFSC){return branchDao.delete(branchIFSC);}

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody Branch updateBranch(@RequestBody Branch branch) {
        return branchDao.update(branch);
    }
}
