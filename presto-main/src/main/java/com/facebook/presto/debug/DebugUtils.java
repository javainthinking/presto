/*
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
package com.facebook.presto.debug;

import java.io.FileWriter;
import java.io.IOException;

public class DebugUtils
{
    public static final String LOG_FILE = "debug.log";

    public static FileWriter fw = null;

    private DebugUtils()
    {
    }

    /**
     * Log the message to the debug log file.
     *
     * @param message
     */
    public static void log(String message)
    {
        try {
            fw = new FileWriter(LOG_FILE, true);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            fw.append(message).append("\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fw.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
