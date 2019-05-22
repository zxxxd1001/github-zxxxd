package com.git.zxxxd.service;

import com.git.zxxxd.bean.Department;
import com.git.zxxxd.bean.Employee;
import com.git.zxxxd.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class DeptService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private  EmployService employService;

    public Department getDeptById(Integer id){
        return departmentMapper.getDeptById(id);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public int deleteDeptByIds(Integer id){
        return departmentMapper.deleteDeptById(id);
    }

    public int deleteDeptById(Integer id){
        //关闭事务自动提交
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = platformTransactionManager.getTransaction(def);
        int i=0;
        try {
            i=departmentMapper.deleteDeptById(id);
            platformTransactionManager.commit(status);
        } catch (Exception e) {
            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }
        return i;
    }

    //默认情况下，事务只有遇到运行期异常时才会回滚，而在遇到检查型异常时不会回滚
    @Transactional(rollbackFor = Exception.class)
    public Department insertDeptById(Department d) throws Exception {
        deleteDeptByIds(20);//注意id值
        if ("asd".equals(d.getDepartmentName())) {
            throw new Exception();
        }
        departmentMapper.insertDeptById(d);
        return  d;
    }

    public int updateDeptById(Department d) {
        return departmentMapper.updateDeptById(d);
    }

    @Transactional(noRollbackFor = RuntimeException.class)
    public int test() {
        Department d=new Department();
        d.setDepartmentName("Department");
        int i= departmentMapper.insertDeptById(d);
        Employee e=new Employee();
        e.setLastName("Employee");
        employService.insertEmploy(e);
        int y=new Integer(null);
        return i;
    }
}
