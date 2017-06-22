/*
 * Copyright 2010-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kotlin.script.dependencies.experimental

import kotlinx.coroutines.experimental.runBlocking
import kotlin.script.dependencies.Environment
import kotlin.script.dependencies.ScriptContents
import kotlin.script.dependencies.ScriptDependenciesResolver
import kotlin.script.dependencies.ScriptDependencyResult

interface AsyncScriptDependenciesResolver : ScriptDependenciesResolver {
    suspend fun resolveAsync(
            scriptContents: ScriptContents, environment: Environment
    ): ScriptDependencyResult

    override fun resolve(scriptContents: ScriptContents, environment: Environment): ScriptDependencyResult
            = runBlocking { resolveAsync(scriptContents, environment) }
}
