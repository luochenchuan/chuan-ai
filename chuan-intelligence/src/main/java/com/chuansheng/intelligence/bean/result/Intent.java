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
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h3></h3>
 *
 * @author ：zhuchuansheng
 * @date: 2020/7/4
 * @time: 14:09
 * @veriosn: 1.0-1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Intent implements Serializable {

  private Integer code;

  private String intentName;

  private String actionName;

  private Map<String, String> parameters;

}
