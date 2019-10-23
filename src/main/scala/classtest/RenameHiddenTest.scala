package classtest

//取别名和屏蔽部分类,_导入剩余所有包
import java.util.{HashMap => JavaHashMap,List => _,_}
class RenameHiddenTest{


}
object RenameHiddenTest extends App{
    val hashMap = new JavaHashMap[String,String]()
//    private val random = new Random
//  new List
    hashMap.put("Hello","scala")
    println(hashMap)
}


