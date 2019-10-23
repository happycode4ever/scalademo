package classtest

object SingletonTest extends App {
  val bean1: CacheBean = CacheBean.getCacheBean
  val bean2: CacheBean = CacheBean.getCacheBean
  println(bean1==bean2)
}
//注意是私有构造器 不要放在类前面 默认会变成private[this]
class CacheBean private()

object CacheBean{
  private var bean:CacheBean = _
  def getCacheBean:CacheBean={
    if(bean == null)
    bean = new CacheBean
    bean
  }
}
