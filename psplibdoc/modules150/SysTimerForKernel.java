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

public class SysTimerForKernel implements HLEModule {
	@Override
	public String getName() { return "SysTimerForKernel"; }
	
	@Override
	public void installModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
		
			mm.addFunction(sceSTimerAllocFunction, 0xC99073E3);
			mm.addFunction(sceSTimerFreeFunction, 0xC105CF38);
			mm.addFunction(SysTimerForKernel_B53534B4Function, 0xB53534B4);
			mm.addFunction(sceSTimerSetHandlerFunction, 0x975D8E84);
			mm.addFunction(sceSTimerStartCountFunction, 0xA95143E2);
			mm.addFunction(sceSTimerStopCountFunction, 0x4A01F9D3);
			mm.addFunction(sceSTimerResetCountFunction, 0x54BB5DB4);
			mm.addFunction(sceSTimerGetCountFunction, 0x228EDAE4);
			mm.addFunction(SysTimerForKernel_53231A15Function, 0x53231A15);
			
		}
	}
	
	@Override
	public void uninstallModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
		
			mm.removeFunction(sceSTimerAllocFunction);
			mm.removeFunction(sceSTimerFreeFunction);
			mm.removeFunction(SysTimerForKernel_B53534B4Function);
			mm.removeFunction(sceSTimerSetHandlerFunction);
			mm.removeFunction(sceSTimerStartCountFunction);
			mm.removeFunction(sceSTimerStopCountFunction);
			mm.removeFunction(sceSTimerResetCountFunction);
			mm.removeFunction(sceSTimerGetCountFunction);
			mm.removeFunction(SysTimerForKernel_53231A15Function);
			
		}
	}
	
	
	public void sceSTimerAlloc(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceSTimerAlloc [0xC99073E3]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceSTimerFree(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceSTimerFree [0xC105CF38]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void SysTimerForKernel_B53534B4(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function SysTimerForKernel_B53534B4 [0xB53534B4]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceSTimerSetHandler(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceSTimerSetHandler [0x975D8E84]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceSTimerStartCount(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceSTimerStartCount [0xA95143E2]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceSTimerStopCount(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceSTimerStopCount [0x4A01F9D3]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceSTimerResetCount(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceSTimerResetCount [0x54BB5DB4]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void sceSTimerGetCount(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function sceSTimerGetCount [0x228EDAE4]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public void SysTimerForKernel_53231A15(Processor processor) {
		CpuState cpu = processor.cpu;

		Modules.log.debug("Unimplemented NID function SysTimerForKernel_53231A15 [0x53231A15]");

		cpu.gpr[2] = 0xDEADC0DE;
	}
    
	public final HLEModuleFunction sceSTimerAllocFunction = new HLEModuleFunction("SysTimerForKernel", "sceSTimerAlloc") {
		@Override
		public final void execute(Processor processor) {
			sceSTimerAlloc(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysTimerForKernelModule.sceSTimerAlloc(processor);";
		}
	};
    
	public final HLEModuleFunction sceSTimerFreeFunction = new HLEModuleFunction("SysTimerForKernel", "sceSTimerFree") {
		@Override
		public final void execute(Processor processor) {
			sceSTimerFree(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysTimerForKernelModule.sceSTimerFree(processor);";
		}
	};
    
	public final HLEModuleFunction SysTimerForKernel_B53534B4Function = new HLEModuleFunction("SysTimerForKernel", "SysTimerForKernel_B53534B4") {
		@Override
		public final void execute(Processor processor) {
			SysTimerForKernel_B53534B4(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysTimerForKernelModule.SysTimerForKernel_B53534B4(processor);";
		}
	};
    
	public final HLEModuleFunction sceSTimerSetHandlerFunction = new HLEModuleFunction("SysTimerForKernel", "sceSTimerSetHandler") {
		@Override
		public final void execute(Processor processor) {
			sceSTimerSetHandler(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysTimerForKernelModule.sceSTimerSetHandler(processor);";
		}
	};
    
	public final HLEModuleFunction sceSTimerStartCountFunction = new HLEModuleFunction("SysTimerForKernel", "sceSTimerStartCount") {
		@Override
		public final void execute(Processor processor) {
			sceSTimerStartCount(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysTimerForKernelModule.sceSTimerStartCount(processor);";
		}
	};
    
	public final HLEModuleFunction sceSTimerStopCountFunction = new HLEModuleFunction("SysTimerForKernel", "sceSTimerStopCount") {
		@Override
		public final void execute(Processor processor) {
			sceSTimerStopCount(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysTimerForKernelModule.sceSTimerStopCount(processor);";
		}
	};
    
	public final HLEModuleFunction sceSTimerResetCountFunction = new HLEModuleFunction("SysTimerForKernel", "sceSTimerResetCount") {
		@Override
		public final void execute(Processor processor) {
			sceSTimerResetCount(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysTimerForKernelModule.sceSTimerResetCount(processor);";
		}
	};
    
	public final HLEModuleFunction sceSTimerGetCountFunction = new HLEModuleFunction("SysTimerForKernel", "sceSTimerGetCount") {
		@Override
		public final void execute(Processor processor) {
			sceSTimerGetCount(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysTimerForKernelModule.sceSTimerGetCount(processor);";
		}
	};
    
	public final HLEModuleFunction SysTimerForKernel_53231A15Function = new HLEModuleFunction("SysTimerForKernel", "SysTimerForKernel_53231A15") {
		@Override
		public final void execute(Processor processor) {
			SysTimerForKernel_53231A15(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.Modules.SysTimerForKernelModule.SysTimerForKernel_53231A15(processor);";
		}
	};
    
};
