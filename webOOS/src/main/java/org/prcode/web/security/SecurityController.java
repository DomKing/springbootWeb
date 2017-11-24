package org.prcode.web.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.prcode.business.basedomain.resourceUrl.domain.ResourceUrlExample;
import org.prcode.business.core.security.resourceUrl.dao.ResourceUrlDao;
import org.prcode.business.core.security.resourceUrl.entity.Menu;
import org.prcode.business.support.basic.SystemConstant;
import org.prcode.business.support.basic.security.util.SecurityUtil;
import org.prcode.socket.OrderNotificationEndPoint;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @className: SecurityController
 * @date: 2017-4-16 16:17
 * @author: kangduo
 * @description: (安全相关controller)
 */
@Controller
public class SecurityController {

    private static final Logger logger = Logger.getLogger(SecurityController.class);

    @Resource
    private ResourceUrlDao resourceUrlDao;
    @Resource
    private OrderNotificationEndPoint orderNotificationEndPoint;

    @GetMapping("/test")
    @ResponseBody
    public String testttt() {
        orderNotificationEndPoint.sendMessageToAll("hello everyone~");
        return "ok";
    }


    @GetMapping(value = "")
    public String index() {
        ResourceUrlExample example = new ResourceUrlExample();
        example.createCriteria().andSysDelStateEqualTo(false)
                .andSystemCodeEqualTo(SystemConstant.OOS_SYSTEM)
                .andIsMenuEqualTo(true);
        example.setOrderByClause("f_order desc");
        List<Menu> menuList = resourceUrlDao.getMenuListByUser(SecurityUtil.getOperId(), SystemConstant.OOS_SYSTEM);
        //菜单排序
        List<Menu> resList = new ArrayList<>(menuList.size());
        Stack<String> stack = new Stack<>();
        stack.push("0");
        menuSort(menuList, stack, resList);
        //放至session，以便各页面能用
        SecurityUtil.getSession().setAttribute("menuList", resList);

        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        if (SecurityUtil.getOperId() != null) {
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping(value = "/logoutSuccess")
    public String logoutSuccess() {
        HttpSession session = SecurityUtil.getSession();
        if (session != null) {
            session.invalidate();
        }
        if (SecurityUtil.getCurrUserDetail() != null) {
            SecurityContextHolder.clearContext();
        }
        logger.debug("用户成功退出登录！");
        return "login";
    }

    @RequestMapping(value = "/deny")
    public String deny() {
        return "deny";
    }

    /**
     * 对菜单进行重排序
     *
     * @param menuList  菜单
     * @param parentIds 父级ID
     * @param resList   重排结果
     */
    private static void menuSort(List<Menu> menuList, Stack<String> parentIds, List<Menu> resList) {
        if (menuList == null || menuList.size() == 0 || parentIds.empty()) {
            return;
        }
        boolean hasChild = false;
        for (Menu menu : menuList) {
            if (menu.getParentId().equals(parentIds.peek())) {
                resList.add(menu);
                parentIds.push(menu.getId());
                menuList.remove(menu);
                hasChild = true;
                break;
            }
        }
        if (!hasChild) {
            parentIds.pop();
        }
        menuSort(menuList, parentIds, resList);
    }
}
