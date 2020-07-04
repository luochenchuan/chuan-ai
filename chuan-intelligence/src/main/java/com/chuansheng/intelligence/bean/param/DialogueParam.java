/******************************************************************************** DESCRIPTION
 *<p>
 *    MODIFIED (YY/MM/DD)
 *
 *
 *    朱川生 2020/7/4 -  
 *
 * <p>
 ******************************************************************************/
package com.chuansheng.intelligence.bean.param;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h3></h3>
 *
 * @author ：zhuchuansheng
 * @date: 2020/7/4
 * @time: 13:49
 * @veriosn: 1.0-1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DialogueParam implements Serializable {

  private Integer reqType = 0;

  private Perception perception;

  private UserInfo userInfo;

}
