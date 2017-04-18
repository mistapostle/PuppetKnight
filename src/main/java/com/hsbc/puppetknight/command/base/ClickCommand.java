package com.hsbc.puppetknight.command.base;

import com.hsbc.puppetknight.command.AbstractCommand;
import com.hsbc.puppetknight.command.SingleMethodCommand;
import org.openqa.selenium.WebElement;

/**
 * Created by mistapostle on 17/4/8.
 */
public class ClickCommand extends AbstractCommand {


    @Override
    protected void doExec(Object target, Object... args) throws Exception {
        WebElement we = (WebElement)target;
        we.click();
    }
}
