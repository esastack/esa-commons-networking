/*
 * Copyright 2021 OPPO ESA Stack Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.esastack.commons.net.netty.buffer;

import esa.commons.annotation.Internal;
import esa.commons.spi.Feature;
import io.esastack.commons.net.buffer.Buffer;
import io.esastack.commons.net.internal.buffer.BufferProvider;
import io.netty.buffer.ByteBuf;

import java.util.Optional;

@Internal
@Feature(order = -1000)
public class NettyBufferProvider implements BufferProvider {

    @Override
    public Optional<Buffer> wrap(Object buffer) {
        if (buffer instanceof ByteBuf) {
            return Optional.of(new BufferImpl((ByteBuf) buffer));
        } else {
            return BufferProvider.super.wrap(buffer);
        }
    }

    @Override
    public Optional<Object> unwrap(Buffer buffer) {
        if (buffer instanceof BufferImpl) {
            return ((BufferImpl) buffer).unwrap();
        } else {
            return BufferProvider.super.unwrap(buffer);
        }
    }
}

