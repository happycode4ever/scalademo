package filetest

object SerializableTest {
  new A()
}
//@SerialVersionUID是scala的注解 目前暂不知道自动生成的方式
@SerialVersionUID(1L) class A extends Serializable
