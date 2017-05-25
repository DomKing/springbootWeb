package org.prcode.aspect;

import org.prcode.log.basedomain.oosLogger.domain.OosLogger;

/**
 * @ClassName: WebOosLog
 * @Date: 2017-04-24 16:13
 * @Auther: kangduo
 * @Description: ()
 */
public class WebOosLog extends OosLogger {
    private static final long serialVersionUID = -1347006064004594290L;
    private String actionDesc;

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }
}
