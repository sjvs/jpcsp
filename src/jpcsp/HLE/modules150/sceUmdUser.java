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

import java.util.LinkedList;
import java.util.List;
import jpcsp.HLE.modules.HLEModule;
import jpcsp.HLE.modules.HLEModuleFunction;
import jpcsp.HLE.modules.HLEModuleManager;

import jpcsp.MemoryMap;
import jpcsp.Memory;
import jpcsp.Processor;
import static jpcsp.util.Utilities.*;

import jpcsp.Allegrex.CpuState; // New-Style Processor
import jpcsp.HLE.SceUIDMan;
import jpcsp.filesystems.umdiso.UmdIsoReader;

public class sceUmdUser implements HLEModule {

    @Override
    public String getName() {
        return "sceUmdUser";
    }

    @Override
    public void installModule(HLEModuleManager mm, int version) {
        System.out.println("UMD - installModule");
        
        if (version >= 150) {

            mm.addFunction(sceUmdCheckMediumFunction, 0x46EBB729);

            mm.addFunction(sceUmdActivateFunction, 0xC6183D47);

            mm.addFunction(sceUmdDeactivateFunction, 0xE83742BA);

            mm.addFunction(sceUmdWaitDriveStatFunction, 0x8EF08FCE);

            mm.addFunction(sceUmdWaitDriveStatWithTimerFunction, 0x56202973);

            mm.addFunction(sceUmdWaitDriveStatCBFunction, 0x4A9E5E29);

            mm.addFunction(sceUmdCancelWaitDriveStatFunction, 0x6AF9B50A);

            mm.addFunction(sceUmdGetDriveStatFunction, 0x6B4A146C);

            mm.addFunction(sceUmdGetErrorStatFunction, 0x20628E6F);

            mm.addFunction(sceUmdGetDiscInfoFunction, 0x340B7686);

            mm.addFunction(sceUmdRegisterUMDCallBackFunction, 0xAEE7404D);

            mm.addFunction(sceUmdUnRegisterUMDCallBackFunction, 0xBD2BDE07);

        }

        UMDCallBackList = new LinkedList<Integer>();
    }

    @Override
    public void uninstallModule(HLEModuleManager mm, int version) {
        if (version >= 150) {

            mm.removeFunction(sceUmdCheckMediumFunction);

            mm.removeFunction(sceUmdActivateFunction);

            mm.removeFunction(sceUmdDeactivateFunction);

            mm.removeFunction(sceUmdWaitDriveStatFunction);

            mm.removeFunction(sceUmdWaitDriveStatWithTimerFunction);

            mm.removeFunction(sceUmdWaitDriveStatCBFunction);

            mm.removeFunction(sceUmdCancelWaitDriveStatFunction);

            mm.removeFunction(sceUmdGetDriveStatFunction);

            mm.removeFunction(sceUmdGetErrorStatFunction);

            mm.removeFunction(sceUmdGetDiscInfoFunction);

            mm.removeFunction(sceUmdRegisterUMDCallBackFunction);

            mm.removeFunction(sceUmdUnRegisterUMDCallBackFunction);

        }
    }

    // HLE helper state

    protected final int PSP_UMD_NOT_PRESENT = 0x01;
    protected final int PSP_UMD_PRESENT = 0x02;
    protected final int PSP_UMD_CHANGED = 0x04;
    protected final int PSP_UMD_INITING = 0x08;
    protected final int PSP_UMD_INITED = 0x10;
    protected final int PSP_UMD_READY = 0x20;

    protected UmdIsoReader iso;
    protected List<Integer> UMDCallBackList;

    // HLE helper functions

    public void setIsoReader(UmdIsoReader iso)
    {
        System.out.println("UMD - setIsoReader " + iso);
        this.iso = iso;
    }

    // Export functions

    public void sceUmdCheckMedium(Processor processor) {
        // CpuState cpu = processor.cpu; // New-Style Processor
        Processor cpu = processor; // Old-Style Processor
        System.out.println("sceUmdCheckMedium (umd mounted = " + (iso != null) + ")");
        cpu.gpr[2] = (iso != null) ? 1 : 0;
    }

    public void sceUmdActivate(Processor processor) {
        // CpuState cpu = processor.cpu; // New-Style Processor
        Processor cpu = processor; // Old-Style Processor
        Memory mem = Processor.memory;
        int unit = cpu.gpr[4]; // should be always 1
        String drive = readStringZ(mem.mainmemory, (cpu.gpr[5] & 0x3fffffff) - MemoryMap.START_RAM);
        System.out.println("sceUmdActivate unit = " + unit + " drive = " + drive);
        cpu.gpr[2] = 0; //return >0 mean success
    }

    public void sceUmdDeactivate(Processor processor) {
        // CpuState cpu = processor.cpu; // New-Style Processor
        Processor cpu = processor; // Old-Style Processor
        Memory mem = Processor.memory;
        /* put your own code here instead */
        // int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
        // float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
        System.out.println("Unimplemented NID function sceUmdDeactivate [0xE83742BA]");
    // cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
    // cpu.fpr[0] = result;
    }

    /** wait until drive stat reaches a0 */
    public void sceUmdWaitDriveStat(Processor processor) {
        // CpuState cpu = processor.cpu; // New-Style Processor
        Processor cpu = processor; // Old-Style Processor
        int stat = cpu.gpr[4];
        System.out.println("sceUmdWaitDriveStat = 0x" + Integer.toHexString(stat));
        //TODO maybe delay current thread to reach the desireable status?
        cpu.gpr[2] = 0;
    }

    /** wait until drive stat reaches a0 */
    public void sceUmdWaitDriveStatWithTimer(Processor processor) {
        // CpuState cpu = processor.cpu; // New-Style Processor
        Processor cpu = processor; // Old-Style Processor
        Memory mem = Processor.memory;
        /* put your own code here instead */
        // int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
        // float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
        System.out.println("Unimplemented NID function sceUmdWaitDriveStatWithTimer [0x56202973]");
    // cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
    // cpu.fpr[0] = result;
    }

    /** wait until drive stat reaches a0 */
    public void sceUmdWaitDriveStatCB(Processor processor) {
        // CpuState cpu = processor.cpu; // New-Style Processor
        Processor cpu = processor; // Old-Style Processor

        int stat = cpu.gpr[4];
        int timeout = cpu.gpr[5];
        System.out.println("sceUmdWaitDriveStatCB stat = 0x" + Integer.toHexString(stat) + " timeout = " + timeout);
        cpu.gpr[0] = 0;

        // TODO are we supposed to block until drive stat changes,
        // and then call any registerd umd cb's?
        // Or are we supposed to "block" until psp finishes checking the
        // drive status? which would just emulate as a yield.
        jpcsp.HLE.ThreadMan.get_instance().yieldCurrentThread();
    }

    public void sceUmdCancelWaitDriveStat(Processor processor) {
        // CpuState cpu = processor.cpu; // New-Style Processor
        Processor cpu = processor; // Old-Style Processor
        Memory mem = Processor.memory;
        /* put your own code here instead */
        // int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
        // float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
        System.out.println("Unimplemented NID function sceUmdCancelWaitDriveStat [0x6AF9B50A]");
    // cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
    // cpu.fpr[0] = result;
    }

    public void sceUmdGetDriveStat(Processor processor) {
        // CpuState cpu = processor.cpu; // New-Style Processor
        Processor cpu = processor; // Old-Style Processor

        int stat;
        if (iso != null) {
            stat = PSP_UMD_PRESENT | PSP_UMD_READY;
        } else {
            stat = PSP_UMD_NOT_PRESENT;
        }

        System.out.println("sceUmdGetDriveStat return:0x" + Integer.toHexString(stat));

        cpu.gpr[2] = stat;
    }

    public void sceUmdGetErrorStat(Processor processor) {
        // CpuState cpu = processor.cpu; // New-Style Processor
        Processor cpu = processor; // Old-Style Processor
        Memory mem = Processor.memory;
        /* put your own code here instead */
        // int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
        // float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
        System.out.println("Unimplemented NID function sceUmdGetErrorStat [0x20628E6F]");
    // cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
    // cpu.fpr[0] = result;
    }

    public void sceUmdGetDiscInfo(Processor processor) {
        // CpuState cpu = processor.cpu; // New-Style Processor
        Processor cpu = processor; // Old-Style Processor
        Memory mem = Processor.memory;
        /* put your own code here instead */
        // int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
        // float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
        System.out.println("Unimplemented NID function sceUmdGetDiscInfo [0x340B7686]");
    // cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
    // cpu.fpr[0] = result;
    }

    // TODO not fully implemented yet
    public void sceUmdRegisterUMDCallBack(Processor processor) {
        // CpuState cpu = processor.cpu; // New-Style Processor
        Processor cpu = processor; // Old-Style Processor

        int uid = cpu.gpr[4];
        System.out.println("UNIMPLEMENTED:sceUmdRegisterUMDCallBack SceUID=" + Integer.toHexString(uid));

        if (SceUIDMan.get_instance().checkUidPurpose(uid, "ThreadMan-callback", false)) {
            UMDCallBackList.add(uid);
            cpu.gpr[2] = 0;
        } else {
            System.out.println("sceUmdRegisterUMDCallBack not a callback uid");
            cpu.gpr[2] = -1;
        }
    }

    public void sceUmdUnRegisterUMDCallBack(Processor processor) {
        // CpuState cpu = processor.cpu; // New-Style Processor
        Processor cpu = processor; // Old-Style Processor

        int uid = cpu.gpr[4];
        System.out.println("sceUmdUnRegisterUMDCallBack SceUID=" + Integer.toHexString(uid));

        if (!SceUIDMan.get_instance().checkUidPurpose(uid, "ThreadMan-callback", false)) {
            System.out.println("sceUmdUnRegisterUMDCallBack not a callback uid");
            cpu.gpr[2] = -1;
        } else {
            Integer copy = UMDCallBackList.remove(uid);
            if (copy == null) {
                System.out.println("sceUmdUnRegisterUMDCallBack not a UMD callback uid");
                cpu.gpr[2] = -1;
            } else {
                cpu.gpr[2] = 0;
            }
        }
    }

    public final HLEModuleFunction sceUmdCheckMediumFunction = new HLEModuleFunction("sceUmdUser", "sceUmdCheckMedium") {

        @Override
        public final void execute(Processor processor) {
            sceUmdCheckMedium(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.modules150.sceUmdUser.sceUmdCheckMediumFunction.execute(processor);";
        }
    };
    public final HLEModuleFunction sceUmdActivateFunction = new HLEModuleFunction("sceUmdUser", "sceUmdActivate") {

        @Override
        public final void execute(Processor processor) {
            sceUmdActivate(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.modules150.sceUmdUser.sceUmdActivateFunction.execute(processor);";
        }
    };
    public final HLEModuleFunction sceUmdDeactivateFunction = new HLEModuleFunction("sceUmdUser", "sceUmdDeactivate") {

        @Override
        public final void execute(Processor processor) {
            sceUmdDeactivate(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.modules150.sceUmdUser.sceUmdDeactivateFunction.execute(processor);";
        }
    };
    public final HLEModuleFunction sceUmdWaitDriveStatFunction = new HLEModuleFunction("sceUmdUser", "sceUmdWaitDriveStat") {

        @Override
        public final void execute(Processor processor) {
            sceUmdWaitDriveStat(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.modules150.sceUmdUser.sceUmdWaitDriveStatFunction.execute(processor);";
        }
    };
    public final HLEModuleFunction sceUmdWaitDriveStatWithTimerFunction = new HLEModuleFunction("sceUmdUser", "sceUmdWaitDriveStatWithTimer") {

        @Override
        public final void execute(Processor processor) {
            sceUmdWaitDriveStatWithTimer(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.modules150.sceUmdUser.sceUmdWaitDriveStatWithTimerFunction.execute(processor);";
        }
    };
    public final HLEModuleFunction sceUmdWaitDriveStatCBFunction = new HLEModuleFunction("sceUmdUser", "sceUmdWaitDriveStatCB") {

        @Override
        public final void execute(Processor processor) {
            sceUmdWaitDriveStatCB(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.modules150.sceUmdUser.sceUmdWaitDriveStatCBFunction.execute(processor);";
        }
    };
    public final HLEModuleFunction sceUmdCancelWaitDriveStatFunction = new HLEModuleFunction("sceUmdUser", "sceUmdCancelWaitDriveStat") {

        @Override
        public final void execute(Processor processor) {
            sceUmdCancelWaitDriveStat(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.modules150.sceUmdUser.sceUmdCancelWaitDriveStatFunction.execute(processor);";
        }
    };
    public final HLEModuleFunction sceUmdGetDriveStatFunction = new HLEModuleFunction("sceUmdUser", "sceUmdGetDriveStat") {

        @Override
        public final void execute(Processor processor) {
            sceUmdGetDriveStat(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.modules150.sceUmdUser.sceUmdGetDriveStatFunction.execute(processor);";
        }
    };
    public final HLEModuleFunction sceUmdGetErrorStatFunction = new HLEModuleFunction("sceUmdUser", "sceUmdGetErrorStat") {

        @Override
        public final void execute(Processor processor) {
            sceUmdGetErrorStat(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.modules150.sceUmdUser.sceUmdGetErrorStatFunction.execute(processor);";
        }
    };
    public final HLEModuleFunction sceUmdGetDiscInfoFunction = new HLEModuleFunction("sceUmdUser", "sceUmdGetDiscInfo") {

        @Override
        public final void execute(Processor processor) {
            sceUmdGetDiscInfo(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.modules150.sceUmdUser.sceUmdGetDiscInfoFunction.execute(processor);";
        }
    };
    public final HLEModuleFunction sceUmdRegisterUMDCallBackFunction = new HLEModuleFunction("sceUmdUser", "sceUmdRegisterUMDCallBack") {

        @Override
        public final void execute(Processor processor) {
            sceUmdRegisterUMDCallBack(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.modules150.sceUmdUser.sceUmdRegisterUMDCallBackFunction.execute(processor);";
        }
    };
    public final HLEModuleFunction sceUmdUnRegisterUMDCallBackFunction = new HLEModuleFunction("sceUmdUser", "sceUmdUnRegisterUMDCallBack") {

        @Override
        public final void execute(Processor processor) {
            sceUmdUnRegisterUMDCallBack(processor);
        }

        @Override
        public final String compiledString() {
            return "jpcsp.HLE.modules150.sceUmdUser.sceUmdUnRegisterUMDCallBackFunction.execute(processor);";
        }
    };
};
