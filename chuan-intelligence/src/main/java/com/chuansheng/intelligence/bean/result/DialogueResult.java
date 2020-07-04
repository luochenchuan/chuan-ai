/******************************************************************************** DESCRIPTION
 *<p>
 *    MODIFIED (YY/MM/DD)
 *
 *
 *    朱川生 2020/7/4 -  
 *
 * <p>
 ******************************************************************************/
package com.chuansheng.intelligence.bean.result;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h3></h3>
 *
 * @author ：zhuchuansheng
 * @date: 2020/7/4
 * @time: 14:08
 * @veriosn: 1.0-1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DialogueResult implements Serializable {

  private Intent intent;

  private Result[] results;

}
