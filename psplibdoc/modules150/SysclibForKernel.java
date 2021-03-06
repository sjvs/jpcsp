/* This autogenerated file is part of jpcsp. */
/*
This file is part of jpcsp.

Jpcsp is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Jpcsp is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jpcsp.  If not, see <http://www.gnu.org/licenses/>.
 */

package jpcsp.HLE.modules150;

import jpcsp.HLE.Modules;
import jpcsp.HLE.modules.HLEModule;
import jpcsp.HLE.modules.HLEModuleFunction;
import jpcsp.HLE.modules.HLEModuleManager;

import jpcsp.Memory;
import jpcsp.Processor;

import jpcsp.Allegrex.CpuState; // New-Style Processor

public class SysclibForKernel implements HLEModule {
	@Override
	public String getName() { return "SysclibForKernel"; }
	
	@Override
	public void installModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
		
			mm.addFunction(strcatFunction, 0x476FD94A);
			mm.addFunction(strcspnFunction, 0x89B79CB1);
			mm.addFunction(indexFunction, 0xD1CD40E5);
			mm.addFunction(rindexFunction, 0x243665ED);
			mm.addFunction(strnlenFunction, 0x90C5573D);
			mm.addFunction(strpbrkFunction, 0x0DFB7B6C);
			mm.addFunction(strspnFunction, 0x62AE052F);
			mm.addFunction(strstrFunction, 0x0D188658);
			mm.addFunction(strtokFunction, 0x87F8D2DA);
			mm.addFunction(strtok_rFunction, 0x1AB53A58);
			mm.addFunction(strtolFunction, 0x47DD934D);
			mm.addFunction(atobFunction, 0x1D83F344);
			mm.addFunction(strtoulFunction, 0x6A7900E1);
			mm.addFunction(SysclibForKernel_8AF6B8F8Function, 0x8AF6B8F8);
			mm.addFunction(SysclibForKernel_DF17F4A2Function, 0xDF17F4A2);
			mm.addFunction(SysclibForKernel_7DEE14DEFunction, 0x7DEE14DE);
			mm.addFunction(SysclibForKernel_5E8E5F42Function, 0x5E8E5F42);
			mm.addFunction(strcmpFunction, 0xC0AB8932);
			mm.addFunction(strcpyFunction, 0xEC6F1CF2);
			mm.addFunction(strchrFunction, 0xB1DC2AE8);
			mm.addFunction(strrchrFunction, 0x4C0E0274);
			mm.addFunction(strncmpFunction, 0x7AB35214);
			mm.addFunction(strncpyFunction, 0xB49A7697);
			mm.addFunction(strlenFunction, 0x52DF196C);
			mm.addFunction(strncatFunction, 0xD3D1A3B9);
			mm.addFunction(memchrFunction, 0x68A78817);
			mm.addFunction(memcpyFunction, 0xAB7592FF);
			mm.addFunction(memsetFunction, 0x10F3BB61);
			mm.addFunction(memcmpFunction, 0x81D0D1F7);
			mm.addFunction(memmoveFunction, 0xA48D2592);
			mm.addFunction(bcopyFunction, 0x097049BD);
			mm.addFunction(bcmpFunction, 0x7F8A6F23);
			mm.addFunction(bzeroFunction, 0x86FEFCE9);
			mm.addFunction(toupperFunction, 0xCE2F7487);
			mm.addFunction(tolowerFunction, 0x3EC5BBF6);
			mm.addFunction(look_ctype_tableFunction, 0x32C767F2);
			mm.addFunction(get_ctype_tableFunction, 0xD887CACD);
			mm.addFunction(prntFunction, 0x87C78FB6);
			mm.addFunction(sprintfFunction, 0x7661E728);
			mm.addFunction(setjmpFunction, 0x909C228B);
			mm.addFunction(longjmpFunction, 0x18FE80DB);
			mm.addFunction(wmemsetFunction, 0x1493EBD9);
			
		}
	}
	
	@Override
	public void uninstallModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
		
			mm.removeFunction(strcatFunction);
			mm.removeFunction(strcspnFunction);
			mm.removeFunction(indexFunction);
			mm.removeFunction(rindexFunction);
			mm.removeFunction(strnlenFunction);
			mm.removeFunction(strpbrkFunction);
			mm.removeFunction(strspnFunction);
			mm.removeFunction(strstrFunction);
			mm.removeFunction(strtokFunction);
			mm.removeFunction(strtok_rFunction);
			mm.removeFunction(strtolFunction);
			mm.removeFunction(atobFunction);
			mm.removeFunction(strtoulFunction);
			mm.removeFunction(SysclibForKernel_8AF6B8F8Function);
			mm.removeFunction(SysclibForKernel_DF17F4A2Function);
			mm.removeFunction(SysclibForKernel_7DEE14DEFunction);
			mm.removeFunction(SysclibForKernel_5E8E5F42Function);
			mm.removeFunction(strcmpFunction);
			mm.removeFunction(strcpyFunction);
			mm.removeFunction(strchrFunction);
			mm.removeFunction(strrchrFunction);
			mm.removeFunction(strncmpFunction);
			mm.removeFunction(strncpyFunction);
			mm.removeFunction(strlenFunction);
			mm.removeFunction(strncatFunction);
			mm.removeFunction(memchrFunction);
			mm.removeFunction(memcpyFunction);
			mm.removeFunction(memsetFunction);
			mm.removeFunction(memcmpFunction);
			mm.removeFunction(memmoveFunction);
			mm.removeFunction(bcopyFunction);
			mm.removeFunction(bcmpFunction);
			mm.removeFunction(bzeroFunction);
			mm.removeFunction(toupperFunction);
			mm.removeFunction(tolowerFunction);
			mm.removeFunction(look_ctype_tableFunction);
			mm.removeFunction(get_ctype_tableFunction);
			mm.removeFunction(prntFunction);
			mm.removeFunction(sprintfFunction);
			mm.removeFunction(setjmpFunction);
			mm.removeFunction(longjmpFunction);
			mm.removeFunction(wmemsetFunction);
			
		}
	}
	
	
	public void strcat(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strcat [0x476FD94A]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strcspn(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strcspn [0x89B79CB1]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void index(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function index [0xD1CD40E5]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void rindex(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function rindex [0x243665ED]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strnlen(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strnlen [0x90C5573D]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strpbrk(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strpbrk [0x0DFB7B6C]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strspn(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strspn [0x62AE052F]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strstr(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strstr [0x0D188658]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strtok(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strtok [0x87F8D2DA]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strtok_r(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strtok_r [0x1AB53A58]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strtol(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strtol [0x47DD934D]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void atob(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function atob [0x1D83F344]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strtoul(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strtoul [0x6A7900E1]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void SysclibForKernel_8AF6B8F8(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function SysclibForKernel_8AF6B8F8 [0x8AF6B8F8]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void SysclibForKernel_DF17F4A2(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function SysclibForKernel_DF17F4A2 [0xDF17F4A2]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void SysclibForKernel_7DEE14DE(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function SysclibForKernel_7DEE14DE [0x7DEE14DE]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void SysclibForKernel_5E8E5F42(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function SysclibForKernel_5E8E5F42 [0x5E8E5F42]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strcmp(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strcmp [0xC0AB8932]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strcpy(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strcpy [0xEC6F1CF2]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strchr(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strchr [0xB1DC2AE8]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strrchr(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strrchr [0x4C0E0274]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strncmp(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strncmp [0x7AB35214]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strncpy(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strncpy [0xB49A7697]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strlen(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strlen [0x52DF196C]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void strncat(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function strncat [0xD3D1A3B9]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void memchr(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function memchr [0x68A78817]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void memcpy(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function memcpy [0xAB7592FF]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void memset(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function memset [0x10F3BB61]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void memcmp(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function memcmp [0x81D0D1F7]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void memmove(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function memmove [0xA48D2592]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void bcopy(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function bcopy [0x097049BD]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void bcmp(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function bcmp [0x7F8A6F23]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void bzero(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function bzero [0x86FEFCE9]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void toupper(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function toupper [0xCE2F7487]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void tolower(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function tolower [0x3EC5BBF6]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void look_ctype_table(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function look_ctype_table [0x32C767F2]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void get_ctype_table(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function get_ctype_table [0xD887CACD]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void prnt(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function prnt [0x87C78FB6]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sprintf(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sprintf [0x7661E728]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void setjmp(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function setjmp [0x909C228B]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void longjmp(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function longjmp [0x18FE80DB]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void wmemset(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function wmemset [0x1493EBD9]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public final HLEModuleFunction strcatFunction = new HLEModuleFunction("SysclibForKernel", "strcat") {
		@Override
		public final void execute(Processor processor) {
			strcat(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strcat(processor);";
		}
	};
    
	public final HLEModuleFunction strcspnFunction = new HLEModuleFunction("SysclibForKernel", "strcspn") {
		@Override
		public final void execute(Processor processor) {
			strcspn(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strcspn(processor);";
		}
	};
    
	public final HLEModuleFunction indexFunction = new HLEModuleFunction("SysclibForKernel", "index") {
		@Override
		public final void execute(Processor processor) {
			index(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.index(processor);";
		}
	};
    
	public final HLEModuleFunction rindexFunction = new HLEModuleFunction("SysclibForKernel", "rindex") {
		@Override
		public final void execute(Processor processor) {
			rindex(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.rindex(processor);";
		}
	};
    
	public final HLEModuleFunction strnlenFunction = new HLEModuleFunction("SysclibForKernel", "strnlen") {
		@Override
		public final void execute(Processor processor) {
			strnlen(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strnlen(processor);";
		}
	};
    
	public final HLEModuleFunction strpbrkFunction = new HLEModuleFunction("SysclibForKernel", "strpbrk") {
		@Override
		public final void execute(Processor processor) {
			strpbrk(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strpbrk(processor);";
		}
	};
    
	public final HLEModuleFunction strspnFunction = new HLEModuleFunction("SysclibForKernel", "strspn") {
		@Override
		public final void execute(Processor processor) {
			strspn(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strspn(processor);";
		}
	};
    
	public final HLEModuleFunction strstrFunction = new HLEModuleFunction("SysclibForKernel", "strstr") {
		@Override
		public final void execute(Processor processor) {
			strstr(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strstr(processor);";
		}
	};
    
	public final HLEModuleFunction strtokFunction = new HLEModuleFunction("SysclibForKernel", "strtok") {
		@Override
		public final void execute(Processor processor) {
			strtok(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strtok(processor);";
		}
	};
    
	public final HLEModuleFunction strtok_rFunction = new HLEModuleFunction("SysclibForKernel", "strtok_r") {
		@Override
		public final void execute(Processor processor) {
			strtok_r(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strtok_r(processor);";
		}
	};
    
	public final HLEModuleFunction strtolFunction = new HLEModuleFunction("SysclibForKernel", "strtol") {
		@Override
		public final void execute(Processor processor) {
			strtol(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strtol(processor);";
		}
	};
    
	public final HLEModuleFunction atobFunction = new HLEModuleFunction("SysclibForKernel", "atob") {
		@Override
		public final void execute(Processor processor) {
			atob(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.atob(processor);";
		}
	};
    
	public final HLEModuleFunction strtoulFunction = new HLEModuleFunction("SysclibForKernel", "strtoul") {
		@Override
		public final void execute(Processor processor) {
			strtoul(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strtoul(processor);";
		}
	};
    
	public final HLEModuleFunction SysclibForKernel_8AF6B8F8Function = new HLEModuleFunction("SysclibForKernel", "SysclibForKernel_8AF6B8F8") {
		@Override
		public final void execute(Processor processor) {
			SysclibForKernel_8AF6B8F8(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.SysclibForKernel_8AF6B8F8(processor);";
		}
	};
    
	public final HLEModuleFunction SysclibForKernel_DF17F4A2Function = new HLEModuleFunction("SysclibForKernel", "SysclibForKernel_DF17F4A2") {
		@Override
		public final void execute(Processor processor) {
			SysclibForKernel_DF17F4A2(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.SysclibForKernel_DF17F4A2(processor);";
		}
	};
    
	public final HLEModuleFunction SysclibForKernel_7DEE14DEFunction = new HLEModuleFunction("SysclibForKernel", "SysclibForKernel_7DEE14DE") {
		@Override
		public final void execute(Processor processor) {
			SysclibForKernel_7DEE14DE(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.SysclibForKernel_7DEE14DE(processor);";
		}
	};
    
	public final HLEModuleFunction SysclibForKernel_5E8E5F42Function = new HLEModuleFunction("SysclibForKernel", "SysclibForKernel_5E8E5F42") {
		@Override
		public final void execute(Processor processor) {
			SysclibForKernel_5E8E5F42(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.SysclibForKernel_5E8E5F42(processor);";
		}
	};
    
	public final HLEModuleFunction strcmpFunction = new HLEModuleFunction("SysclibForKernel", "strcmp") {
		@Override
		public final void execute(Processor processor) {
			strcmp(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strcmp(processor);";
		}
	};
    
	public final HLEModuleFunction strcpyFunction = new HLEModuleFunction("SysclibForKernel", "strcpy") {
		@Override
		public final void execute(Processor processor) {
			strcpy(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strcpy(processor);";
		}
	};
    
	public final HLEModuleFunction strchrFunction = new HLEModuleFunction("SysclibForKernel", "strchr") {
		@Override
		public final void execute(Processor processor) {
			strchr(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strchr(processor);";
		}
	};
    
	public final HLEModuleFunction strrchrFunction = new HLEModuleFunction("SysclibForKernel", "strrchr") {
		@Override
		public final void execute(Processor processor) {
			strrchr(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strrchr(processor);";
		}
	};
    
	public final HLEModuleFunction strncmpFunction = new HLEModuleFunction("SysclibForKernel", "strncmp") {
		@Override
		public final void execute(Processor processor) {
			strncmp(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strncmp(processor);";
		}
	};
    
	public final HLEModuleFunction strncpyFunction = new HLEModuleFunction("SysclibForKernel", "strncpy") {
		@Override
		public final void execute(Processor processor) {
			strncpy(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strncpy(processor);";
		}
	};
    
	public final HLEModuleFunction strlenFunction = new HLEModuleFunction("SysclibForKernel", "strlen") {
		@Override
		public final void execute(Processor processor) {
			strlen(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strlen(processor);";
		}
	};
    
	public final HLEModuleFunction strncatFunction = new HLEModuleFunction("SysclibForKernel", "strncat") {
		@Override
		public final void execute(Processor processor) {
			strncat(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.strncat(processor);";
		}
	};
    
	public final HLEModuleFunction memchrFunction = new HLEModuleFunction("SysclibForKernel", "memchr") {
		@Override
		public final void execute(Processor processor) {
			memchr(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.memchr(processor);";
		}
	};
    
	public final HLEModuleFunction memcpyFunction = new HLEModuleFunction("SysclibForKernel", "memcpy") {
		@Override
		public final void execute(Processor processor) {
			memcpy(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.memcpy(processor);";
		}
	};
    
	public final HLEModuleFunction memsetFunction = new HLEModuleFunction("SysclibForKernel", "memset") {
		@Override
		public final void execute(Processor processor) {
			memset(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.memset(processor);";
		}
	};
    
	public final HLEModuleFunction memcmpFunction = new HLEModuleFunction("SysclibForKernel", "memcmp") {
		@Override
		public final void execute(Processor processor) {
			memcmp(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.memcmp(processor);";
		}
	};
    
	public final HLEModuleFunction memmoveFunction = new HLEModuleFunction("SysclibForKernel", "memmove") {
		@Override
		public final void execute(Processor processor) {
			memmove(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.memmove(processor);";
		}
	};
    
	public final HLEModuleFunction bcopyFunction = new HLEModuleFunction("SysclibForKernel", "bcopy") {
		@Override
		public final void execute(Processor processor) {
			bcopy(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.bcopy(processor);";
		}
	};
    
	public final HLEModuleFunction bcmpFunction = new HLEModuleFunction("SysclibForKernel", "bcmp") {
		@Override
		public final void execute(Processor processor) {
			bcmp(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.bcmp(processor);";
		}
	};
    
	public final HLEModuleFunction bzeroFunction = new HLEModuleFunction("SysclibForKernel", "bzero") {
		@Override
		public final void execute(Processor processor) {
			bzero(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.bzero(processor);";
		}
	};
    
	public final HLEModuleFunction toupperFunction = new HLEModuleFunction("SysclibForKernel", "toupper") {
		@Override
		public final void execute(Processor processor) {
			toupper(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.toupper(processor);";
		}
	};
    
	public final HLEModuleFunction tolowerFunction = new HLEModuleFunction("SysclibForKernel", "tolower") {
		@Override
		public final void execute(Processor processor) {
			tolower(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.tolower(processor);";
		}
	};
    
	public final HLEModuleFunction look_ctype_tableFunction = new HLEModuleFunction("SysclibForKernel", "look_ctype_table") {
		@Override
		public final void execute(Processor processor) {
			look_ctype_table(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.look_ctype_table(processor);";
		}
	};
    
	public final HLEModuleFunction get_ctype_tableFunction = new HLEModuleFunction("SysclibForKernel", "get_ctype_table") {
		@Override
		public final void execute(Processor processor) {
			get_ctype_table(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.get_ctype_table(processor);";
		}
	};
    
	public final HLEModuleFunction prntFunction = new HLEModuleFunction("SysclibForKernel", "prnt") {
		@Override
		public final void execute(Processor processor) {
			prnt(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.prnt(processor);";
		}
	};
    
	public final HLEModuleFunction sprintfFunction = new HLEModuleFunction("SysclibForKernel", "sprintf") {
		@Override
		public final void execute(Processor processor) {
			sprintf(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.sprintf(processor);";
		}
	};
    
	public final HLEModuleFunction setjmpFunction = new HLEModuleFunction("SysclibForKernel", "setjmp") {
		@Override
		public final void execute(Processor processor) {
			setjmp(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.setjmp(processor);";
		}
	};
    
	public final HLEModuleFunction longjmpFunction = new HLEModuleFunction("SysclibForKernel", "longjmp") {
		@Override
		public final void execute(Processor processor) {
			longjmp(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.longjmp(processor);";
		}
	};
    
	public final HLEModuleFunction wmemsetFunction = new HLEModuleFunction("SysclibForKernel", "wmemset") {
		@Override
		public final void execute(Processor processor) {
			wmemset(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysclibForKernelModule.wmemset(processor);";
		}
	};
    
};
