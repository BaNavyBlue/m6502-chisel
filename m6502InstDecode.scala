package problems

import chisel3._
import chisel3.util._

class InstructionDecode extends Module{
  val io = IO(new Bundle{
    val instruction = Input(UInt(8.W))
    val ready = Input(UInt(1.W))
    val reset = Input(UInt(1.W))
    val interuptLogic = Input(UInt(3.W))
    val timingControl = Input(UInt(4.W))
    val processorStatusRegIn = Input(UInt(8.W))
    val regA = Output(UInt(1.W))
    val regX = Output(UInt(1.W))
    val regY = Output(UInt(1.W))
    val regSP = Output(UInt(1.W))
    val regPCL = Output(UInt(1.W))
    val regPCH = Output(UInt(1.W))
    val regALU = Output(UInt(1.W))
    val rW = Output(UInt(1.W))
  })
  val cycles = RegInit(0.U(3.W))

  switch(io.instruction){ 
    is("h00".U){ // BRKb

    }
    is("h01".U){ // ORAx

    }
    is("h05".U){ // ORAzpg
        
    }
    is("h06".U){ // ASLzpg

    }
    is("h08".U){ // PHPimpl

    }
    is("h09".U){ // ORA#

    }
    is("h0a".U){ // ASL_A

    }
    is("h0d".U){ // ORAabs

    }
    is("h0E".U){ // ASLabs

    }
    is("h10".U){ // BPLrel

    }
    is("h11".U){ // ORAindY

    }
    is("h15".U){ // ORAzpgX

    }
    is("h16".U){ // ASLzpgX

    }
    is("h18".U){ // CLCimpl

    }
    is("h19".U){ // ORAabsY

    }
    is("h1D".U){ // ORAabsX

    }
    is("h1E".U){ // ASLabsX

    }
    is("h20".U){ // JSRabs

    }
    is("h21".U){ // ANDXind

    }
    is("h24".U){ // BITzpg

    }
    is("h25".U){ // ANDzpg

    }
    is("h26".U){ // ROLzpg

    }
    is("h28".U){ // PLPimpl
        
    }
    is("h29".U){ // AND#

    }
    is("h2A".U){ // ROLA

    }
    is("h2C".U){ // BITabs

    }
    is("h2D".U){ // ANDabs

    }
    is("h2E".U){ // ROLabs

    }
    is("h30".U){ // BMIrel

    }
    is("h31".U){ // ANDindY

    }
    is("h35".U){ // ANDzpgX

    }
    is("h36".U){ // ROLzpgX

    }
    is("h38".U){ // SECimpl

    }
    is("h39".U){ // ANDabsY

    }
    is("h3D".U){ // ANDabsX

    }
    is("h3E".U){ // ROLabsX

    }
    is("h40".U){ // RTIimpl

    }
    is("h41".U){ // EORXind

    }
    is("h45".U){ // EORzpg

    }
    is("h46".U){ // LSRzpg

    }
    is("h48".U){ // PHAimpl

    }
    is("h49".U){ // EOR#

    }
    is("h4A".U){ // LSRA

    }
    is("h4C".U){ // JMPabs

    }
    is("h4D".U){ // EORabs

    }
    is("h4E".U){ // LSRabs

    }
    is("h50".U){ // BVCrel

    }
    is("h51".U){ // EORindY

    }
    is("h55".U){ // EORzpgX

    }
    is("h56".U){ // LSRzpgX

    }
    is("h58".U){ // CLIimpl

    }
    is("h59".U){ // EORabsY

    }
    is("h5D".U){ // EORabsX

    }
    is("h5E".U){ // LSRabsX

    }
    is("h60".U){ // RTSimpl

    }
    is("h61".U){ // ADCXind

    }
    is("h65".U){ // ADCzpg

    }
    is("h66".U){ // RORzpg

    }
    is("h68".U){ // PLAimpl

    }
    is("h69".U){ // ADC#

    }
    is("h6A".U){ // RORA

    }
    is("h6C".U){ // JMPind

    }
    is("h6D".U){ // ADCabs

    }
    is("h6E".U){ // RORabs

    }
    is("h70".U){ // BVSrel

    }
    is("h71".U){ // ADCindY

    }
    is("h75".U){ // ADCzpgX

    }
    is("h76".U){ // RORzpgX

    }
    is("h78".U){ // SEIimpl

    }
    is("h79".U){ // ADCabsY

    }
    is("h7D".U){ // ADCabsX

    }
    is("h7E".U){ // RORabsX

    }
    is("h81".U){ // STAXind

    }
    is("h84".U){ // STYzpg

    }
    is("h85".U){ // STAzpg

    }
    is("h86".U){ // STXzpg

    }
    is("h88".U){ // DEYimpl

    }
    is("h8a".U){ // TXAimpl

    }
    is("h8c".U){ // STYabs

    }
    is("h8d".U){ // STAabs

    }
    is("h8e".U){ // STXabs

    }
    is("h90".U){ // BCCrel

    }
    is("h91".U){ // STAindY

    }
    is("h94".U){ // STYzpgX

    }
    is("h95".U){ // STAzpgX

    }
    is("h96".U){ // STXzpgY

    }
    is("h98".U){ // TYAimpl

    }
    is("h99".U){ // STAabsY

    }
    is("h9a".U){ // TXSimpl

    }
    is("h9d".U){ // STAabsX

    }
    is("ha0".U){ // LDY#

    }
    is("ha1".U){ // LDAXind

    }
    is("ha2".U){ // LDX#

    }
    is("ha4".U){ // LDYzpg

    }
    is("ha5".U){ // LDAzpg

    }
    is("ha6".U){ // LDXzpg

    }
    is("ha8".U){ // TAYimpl

    }
    is("ha9".U){ // LDA#

    }
    is("haa".U){ // TAXimpl

    }
    is("hac".U){ // LDYabs

    }
    is("had".U){ // LDAabs

    }
    is("hae".U){ // LDXabs

    }
    is("hb0".U){ // BCSrel

    }
    is("hb1".U){ // LDAindY

    }
    is("hb4".U){ // LDYzpgX

    }
    is("hb5".U){ // LDAzpgX

    }
    is("hb6".U){ // LDXzpgY

    }
    is("hb8".U){ // CLVimp

    }
    is("hb9".U){ // LDAabsY

    }
    is("hba".U){ // TSXimpl

    }
    is("hbc".U){ // LDYabsX

    }
    is("hbd".U){ // LDAabsX

    }
    is("hbe".U){ // LDXabsY

    }
    is("hc0".U){ // CPU#

    }
    is("hc1".U){ // CMPXind

    }
    is("hc4".U){ // CPYzpg

    }
    is("hc5".U){ // CMPzpg

    }
    is("hc6".U){ // DECzpg

    }
    is("hc8".U){ // INYimpl

    }
    is("hc9".U){ // CMP#

    }
    is("hcA".U){ // DEXimpl

    }
    is("hcc".U){ // CPYabs

    }
    is("hcd".U){ // CMPabs

    }
    is("hce".U){ // DECabs

    }
    is("hd0".U){ // BNErel

    }
    is("hd1".U){ // CMPindY

    }
    is("hd5".U){ // CMPzpgX

    }
    is("hd6".U){ // DECzpgX

    }
    is("hd8".U){ // CLDimpl

    }
    is("hd9".U){ // CMPabsY

    }
    is("hdd".U){ // CMPabsX

    }
    is("hde".U){ // DECabsX

    }
    is("he0".U){ // CPX#

    }
    is("he1".U){ // SBCXind

    }
    is("he4".U){ // CPXzpg

    }
    is("he5".U){ // SBCzpg
        
    }
    is("he6".U){ // INCzpg

    }
    is("he8".U){ // INXimpl

    }
    is("he9".U){ // SBC#

    }
    is("hea".U){ // NOPimpl

    }
    is("hec".U){ // CPXabs

    }
    is("hed".U){ // SBCabs

    }
    is("hee".U){ // INCabs

    }
    is("hf0".U){ // BEQrel

    }
    is("hf1".U){ // SBCindY

    }
    is("hf5".U){ // SBCzpgX

    }
    is("hf6".U){ // INCzpgX

    }
    is("hf8".U){ // SEDimpl

    }
    is("hf9".U){ // SBCabsY

    }
    is("hfd".U){ // SBCabsX

    }
    is("hfe".U){ // INCabsX

    }
  }

}