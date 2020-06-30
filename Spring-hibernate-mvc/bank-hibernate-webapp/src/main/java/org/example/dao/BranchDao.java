package org.example.dao;

import org.example.model.Branch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class BranchDao {

    protected SessionFactory sessionFactory;

    private void setup() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    private void exit() {
        sessionFactory.close();
    }

    public Branch create(Branch branch) {
        Branch newBranch = new Branch();
        newBranch.setBranchIFSC(branch.getBranchIFSC());
        newBranch.setName(branch.getName());
        newBranch.setType(branch.getType());
        newBranch.setType(branch.getType());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(newBranch);
        session.getTransaction().commit();
        session.close();
        return newBranch;
    }

    public List<Branch> read() {
        Session session = sessionFactory.openSession();
        System.out.println(session.createQuery("FROM Branch").list() + "\n");
        session.close();
        return null;
    }

    public Branch update(Branch branch) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Branch oldBranch = (Branch) session.load(Branch.class, branch.getBranchIFSC());
        oldBranch.setBranchIFSC(branch.getBranchIFSC());
        oldBranch.setName(branch.getName());
        oldBranch.setType(branch.getType());
        oldBranch.setAddress(branch.getAddress());
        session.getTransaction().commit();
        session.close();
        return branch;
    }

    public String delete(String branchIFSC) {
        Branch oldBranch = new Branch();
        oldBranch.setBranchIFSC(branchIFSC);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(oldBranch);
        session.getTransaction().commit();
        session.close();
        return "branch deleted successfully";

    }
}
