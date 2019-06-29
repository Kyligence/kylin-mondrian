/*
 *
 *  * Copyright (C) 2016 Kyligence Inc. All rights reserved.
 *  *
 *  * http://kyligence.io
 *  *
 *  * This software is the confidential and proprietary information of
 *  * Kyligence Inc. ("Confidential Information"). You shall not disclose
 *  * such Confidential Information and shall use it only in accordance
 *  * with the terms of the license agreement you entered into with
 *  * Kyligence Inc.
 *  *
 *  * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *  * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 *  * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 *  * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 *  * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 *  * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 *  * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 *  * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package mondrian.rolap;

import mondrian.olap.Larder;
import mondrian.spi.MemberFormatter;
import org.olap4j.metadata.Level;

import java.util.List;

public class RolapDimensionAttribute extends RolapAttributeImpl {

    private RolapDimension dimension;

    public RolapDimensionAttribute(String name,
                                   boolean visible,
                                   List<RolapSchema.PhysColumn> keyList,
                                   RolapSchema.PhysColumn nameExp,
                                   RolapSchema.PhysColumn captionExp,
                                   List<RolapSchema.PhysColumn> orderByList,
                                   MemberFormatter memberFormatter,
                                   Level.Type levelType,
                                   int approxRowCount,
                                   Larder larder,
                                   RolapDimension dimension) {
        super(name, visible, keyList, nameExp, captionExp, orderByList, memberFormatter, levelType, approxRowCount, larder);
        this.dimension = dimension;
    }

    @Override
    public RolapDimension getDimension() {
        return this.dimension;
    }

    @Override
    public RolapAttribute cloneWithNewKeyCols(List<RolapSchema.PhysColumn> keyList, List<RolapSchema.PhysColumn> orderByList) {
        return new RolapDimensionAttribute(this.name, this.visible, keyList, this.nameExp, this.captionExp, orderByList, this.memberFormatter, this.levelType, this.getApproxRowCount(), this.getLarder(), this.dimension);
    }
}
