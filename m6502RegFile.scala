
import chisel3._
import chisel3.util._
// import chisel3.tester._
// import chisel3.tester.RawTester.test

class RegisterFile extends Module{
  val io = IO(new Bundle {
    val regSel = Input(Uint(2.W))
    val readWrite = Input(Unint(1.W))
    val in = Input(Uint(8.W)) 
    val out = Output(Uint(8.W)) 
  })

  val A :: X :: Y :: Nil = Enum(3.U)
  val READ :: WRITE :: Nil = Enum(2.U)

  val RegA = Reg(Uint(8.W))
  val RegX = Reg(Uint(8.W))
  val RegY = Reg(Uint(8.W))

  when(io.readWrite === READ){
    when(io.regSel === A){
     io.out := RegA
    }.elsewhen(io.regSel === X){
      io.out := RegX
    }.elsewhen(io.regSel === Y){
      io.out := RegY
    }
  }.elsewhen(io.readWrite === WRITE){
    when(io.regSel === A){
      RegA := io.input
    }.elsewhen(io.regSel === X){
      RegX := io.input
    }.elsewhen(io.regSel === Y){
      RegY := io.input
    }
  }

}