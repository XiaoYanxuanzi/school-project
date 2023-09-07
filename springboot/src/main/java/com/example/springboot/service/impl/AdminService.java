package com.example.springboot.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.controller.request.NewPassWordRequest;
import com.example.springboot.domain.Admin;
import com.example.springboot.domain.User;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.AdminMapper;
import com.example.springboot.service.IAdminService;
import com.example.springboot.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class AdminService implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;
    //加盐和初始化密码
    private static String FirstPassword = "123";
    private static String SALT = "SAVEKEY";

    @Override
    public PageInfo<Admin> page(AdminPageRequest adminPageRequest) {
        PageHelper.startPage(adminPageRequest.getPageNum(), adminPageRequest.getPageSize());
        List<Admin> admins = adminMapper.listByCondition(adminPageRequest);
        return new PageInfo<>(admins);
    }

    @Override
    public void save(Admin admin) {

        if (StringUtils.isEmpty(admin.getPassword())){
            admin.setPassword(FirstPassword);
        }

        admin.setPassword(SecureUtil.md5(admin.getPassword() + SALT));
        try {
            adminMapper.save(admin);
        } catch (DuplicateKeyException e) {
            log.error("数据插入失败， username:{}", admin.getUsername(), e);
            throw new ServiceException("用户名重复");
        }
    }

    @Override
    public Admin getById(Integer id) {
       return adminMapper.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        adminMapper.deleteById(id);
    }

    @Override
    public void update(Admin admin) {
        admin.setUpdatetime(new Date());
        adminMapper.update(admin);
    }

    @Override
    public LoginDTO login(LoginRequest request) {
        request.setPassword(SecureUtil.md5(request.getPassword() + SALT));
        Admin admin = adminMapper.getByUsernameAndPassword(request);

        if(admin == null){
            throw new ServiceException("账号或密码错误");
        }

        if(admin.getUsername() == null){
            throw new ServiceException("用户不存在");
        }

        if (admin.isStatus() == false) {
            throw new ServiceException("当前用户处于禁用状态，请联系管理员");
        }
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(admin,loginDTO);
        // 生成token
        String token = TokenUtils.genToken(String.valueOf(admin.getId()), admin.getPassword());
        loginDTO.setToken(token);
        return loginDTO;
    }

    @Override
    public void changePass(NewPassWordRequest request) {
        request.setNewPass(SecureUtil.md5(request.getNewPass() + SALT));
        int count = adminMapper.updatePassword(request);
        if (count <= 0) {
            throw new ServiceException("修改密码失败");
        }
    }


//    @Override
//    public List<Admin> listadmins() {
//
//        return adminMapper.listAdmins();
//    }


}
